package MiddleLayer;

import DataLayer.GetResultSet;
import DataLayer.IsExistsInDB;
import DataLayer.Students;
import UiLayer.Student;

import java.sql.ResultSet;

public class AddOrGetStudentsML {
    public static void addStudent(Student studentInfo)
    {

        Students studentsObj=new Students();
        studentsObj.insertIntoStudent(studentInfo);

    }
    public boolean isRollNumberOrNameExists(String rollNoOrName)
    {
        String query="SELECT EXISTS(SELECT * FROM StudentsDetails WHERE RollNumber='"+ rollNoOrName +"'||Name='"+ rollNoOrName +"') AS res";
        return IsExistsInDB.isExistsInDB(query);
    }
    public ResultSet getStudentProfile(String rollNoOrName)
    {
        String query="SELECT * FROM StudentsDetails WHERE RollNumber='"+ rollNoOrName +"'||Name='"+ rollNoOrName +"'";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }

    public ResultSet getStudentsList()
    {
        String query="SELECT Id,RollNumber,Name FROM StudentsDetails";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }
}
