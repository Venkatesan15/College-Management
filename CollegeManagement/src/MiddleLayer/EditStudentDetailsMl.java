package MiddleLayer;

import DataLayer.GetResultSet;
import DataLayer.IsExistsInDB;
import DataLayer.UpdateInDB;

import java.sql.ResultSet;

public class EditStudentDetailsMl {
    public boolean isRollNoOrNameExists(String rollNoOrName)
    {
        String query="SELECT EXISTS(SELECT * FROM StudentsDetails WHERE RollNumber='"+rollNoOrName+"'||Name='"+rollNoOrName+"')AS res";
        return IsExistsInDB.isExistsInDB(query);
    }
    public ResultSet getDetailsUsingRNOrName(String rollNoOrName)
    {
        String query="SELECT * FROM StudentsDetails WHERE RollNumber='"+ rollNoOrName +"'||Name='"+rollNoOrName+"'";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }
    public void editStudentDetail(String columnName, String changes, String rollNoOrName)
    {
        String query="update StudentsDetails SET "+ columnName +"='"+changes+"' WHERE RollNumber='"+ rollNoOrName +"'||Name='"+ rollNoOrName +"'";
        UpdateInDB updateInDBObj=new UpdateInDB();
        updateInDBObj.update(query);
    }
    public void editAge(int age,String rollNoOrName)
    {
        String query="update StudentsDetails SET Age='"+age+"' WHERE RollNumber='"+ rollNoOrName +"'||Name='"+rollNoOrName+"'";
        UpdateInDB updateInDBObj=new UpdateInDB();
        updateInDBObj.update(query);
    }
    public void changeRegInStudentFeesTable(String rollNoOrName,String newRollNo)
    {
        String query="update StudentFeesTable SET RollNumber='"+newRollNo+"' WHERE RollNumber='"+ rollNoOrName+"'||Name='"+rollNoOrName+"'";
        UpdateInDB updateInDBObj=new UpdateInDB();
        updateInDBObj.update(query);

    }
//    public boolean isNameThere(String name)
//    {
//        String query="SELECT EXISTS(SELECT * FROM StudentsDetails WHERE Name='"+name+"')AS res";
//        return IsExistsInDB.isExistsInDB(query);
//    }
    public void changeNameInStudentFeesTable(String rollNoOrName,String newName)
    {
        String query="update StudentFeesTable SET Name='"+newName+"' WHERE Name='"+ rollNoOrName+"'||RollNumber='"+rollNoOrName+"'";
        UpdateInDB updateInDBObj=new UpdateInDB();
        updateInDBObj.update(query);

    }
}
