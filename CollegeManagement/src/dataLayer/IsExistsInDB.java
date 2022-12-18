package dataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IsExistsInDB {
    public static boolean isExistsInDB(String query)
    {
        try
        {
            Jdbc jdbcObj=new Jdbc();
            Connection con=jdbcObj.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            if(rs.getInt("res")==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }
        return false;
    }
    public boolean isColumnNameExists(String columnName,String rollNoOrName)
    {
        try
        {
            Jdbc jdbcObj=new Jdbc();
            Connection con=jdbcObj.getConnection();

            String query="SELECT EXISTS(SELECT "+ columnName +" FROM StudentFeesTable) AS res";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            if(rs.getInt("res")==1)
            {
                String query1="UPDATE StudentFeesTable SET "+ columnName +" = 'PAID' WHERE RollNumber='"+rollNoOrName+"'||Name='"+rollNoOrName+"'";
                UpdateInDB updateInDBObj=new UpdateInDB();
                updateInDBObj.update(query1);
                return true;
            }

        }
        catch(Exception e)
        {
            return false;
        }
        return false;
    }
}
