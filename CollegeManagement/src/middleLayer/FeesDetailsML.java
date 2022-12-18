package middleLayer;

import dataLayer.ResultSet;
import dataLayer.UpdateInDB;
import dataLayer.IsExistsInDB;

public class FeesDetailsML {
    public java.sql.ResultSet getFeesDetail()
    {
        String query="SELECT Particulars,Amount,LastDate FROM FixedFeesDetails";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }
    public boolean isParticularAvailable()
    {
        String query="SELECT EXISTS(SELECT * FROM FixedFeesDetails) AS res";
        return IsExistsInDB.isExistsInDB(query);
    }


    public void setFees(String particulars, long amount, String date)
    {
        String query="INSERT INTO FixedFeesDetails(Particulars,Amount,LastDate) VALUES('"+particulars+"','"+amount+"','"+date+"')";
        UpdateInDB updateInDBObj =new UpdateInDB();
        updateInDBObj.update(query);


        String query1="ALTER TABLE StudentFeesTable ADD COLUMN "+ particulars +" VARCHAR(30)";
        updateInDBObj.update(query1);

        String query2="UPDATE StudentFeesTable SET "+ particulars +" = ' UNPAID '";
        updateInDBObj.update(query2);
    }
    public boolean isParticularAvailable(String particular)
    {
        String query1="SELECT EXISTS(SELECT * FROM FixedFeesDetails WHERE Particulars='"+particular+"') AS res";
        return IsExistsInDB.isExistsInDB(query1);

    }
    public void deleteParticular(String particular)
    {
        String query="DELETE FROM FixedFeesDetails WHERE Particulars='"+particular+"'";
        UpdateInDB updateInDBObj =new UpdateInDB();
        updateInDBObj.update(query);

        String query1="ALTER TABLE StudentFeesTable DROP "+ particular +"";
        updateInDBObj.update(query1);
    }

    public java.sql.ResultSet getStudentsPaidDetails()
    {
        String query="SELECT * FROM StudentFeesTable";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }

    //Student

    public boolean isColumnNameExists(String columnName,String rollNoOrName)
    {
        IsExistsInDB isExistsInDBObj=new IsExistsInDB();
        return isExistsInDBObj.isColumnNameExists(columnName,rollNoOrName);

    }

    public java.sql.ResultSet getColumnNames()
    {
        String query="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE `TABLE_SCHEMA`='CollegeManagement' and `TABLE_NAME`='StudentFeesTable'";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }

    public boolean getUnpaidColumnNames(String rollNoOrName,String columnName)
    {
        String query="SELECT EXISTS(SELECT * FROM StudentFeesTable WHERE (RollNumber='"+ rollNoOrName +"'||Name='"+rollNoOrName+"') and "+ columnName +" = ' UNPAID ') AS res";
        return IsExistsInDB.isExistsInDB(query);
    }

}
