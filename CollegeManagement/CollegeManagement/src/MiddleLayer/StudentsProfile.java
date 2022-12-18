package MiddleLayer;

import DataLayer.ResultSet;
import DataLayer.IsExistsInDB;
import DataLayer.Students;
import UiLayer.Student;

public class StudentsProfile {
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
    public java.sql.ResultSet getStudentProfile(String rollNoOrName)
    {
        String query="SELECT * FROM StudentsDetails WHERE RollNumber='"+ rollNoOrName +"'||Name='"+ rollNoOrName +"'";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }

    public java.sql.ResultSet getStudentsList()
    {
        String query="SELECT Id,RollNumber,Name FROM StudentsDetails";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }
    public java.sql.ResultSet getName()
    {
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet("SELECT RollNumber,Name FROM StudentsDetails");
    }
}
