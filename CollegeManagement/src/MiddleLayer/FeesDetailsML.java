package MiddleLayer;

import DataLayer.GetResultSet;
import DataLayer.UpdateInDB;
import DataLayer.IsExistsInDB;

import java.sql.ResultSet;

public class FeesDetailsML {


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

    public ResultSet getStudentsPaidDetails()
    {
        String query="SELECT * FROM StudentFeesTable";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }

    //Student

    public boolean isColumnNameExists(String columnName,String rollNoOrName)
    {
        IsExistsInDB isExistsInDBObj=new IsExistsInDB();
        return isExistsInDBObj.isColumnNameExists(columnName,rollNoOrName);

    }

    public  ResultSet getColumnNames()
    {
        String query="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE `TABLE_SCHEMA`='CollegeManagement' and `TABLE_NAME`='StudentFeesTable'";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }

    public boolean getUnpaidColumnNames(String rollNoOrName,String columnName)
    {
        String query="SELECT EXISTS(SELECT * FROM StudentFeesTable WHERE (RollNumber='"+ rollNoOrName +"'||Name='"+rollNoOrName+"') and "+ columnName +" = ' UNPAID ') AS res";
        return IsExistsInDB.isExistsInDB(query);
    }

}
