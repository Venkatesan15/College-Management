package DataLayer;

import MiddleLayer.FeesDetailsML;
import UiLayer.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Students {
    public void insertIntoStudent(Student studentInfo)
    {

        try
        {
            Jdbc jdbcObj=new Jdbc();
            Connection con=jdbcObj.getConnection();
            String query="INSERT INTO StudentsDetails(RollNumber,Name,Gender,PhoneNumber,DOB,Age) VALUES(?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(query);
            st.setString(1,studentInfo.getRollNo());
            st.setString(2,studentInfo.getName());
            st.setString(3,studentInfo.getGender());
            st.setString(4,studentInfo.getPhNo());
            st.setString(5,studentInfo.getDob());
            st.setInt(6,studentInfo.getAge());
            st.executeUpdate();


            String query1="INSERT INTO StudentFeesTable(RollNumber,Name) values('"+studentInfo.getRollNo()+"','"+studentInfo.getName()+"')";
            UpdateInDB updateInDBObj=new UpdateInDB();
            updateInDBObj.update(query1);

            setUnpaid(studentInfo.getRollNo());

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void setUnpaid(String rollNumber)
    {
        FeesDetailsML feesDetailsMLObj=new FeesDetailsML();
        ResultSet columnNamesRS=feesDetailsMLObj.getColumnNames();

        try {
            while (columnNamesRS.next()) {
                if(!(columnNamesRS.getString("COLUMN_NAME").equals("RollNumber")||columnNamesRS.getString("COLUMN_NAME").equals("Name")))
                {
                    String query = "UPDATE StudentFeesTable SET " + columnNamesRS.getString("COLUMN_NAME") + "=' UNPAID ' WHERE RollNumber='" + rollNumber + "'";
                    UpdateInDB updateInDBObj = new UpdateInDB();
                    updateInDBObj.update(query);
                }

            }

        }
        catch (Exception e)
        {
            System.out.println("Exception in StudentsDL : "+e);

        }
    }
}
