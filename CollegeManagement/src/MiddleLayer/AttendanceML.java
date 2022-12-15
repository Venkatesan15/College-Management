package MiddleLayer;

import DataLayer.GetResultSet;
import DataLayer.IsExistsInDB;
import DataLayer.UpdateInDB;

import java.sql.ResultSet;

public class AttendanceML {
    public void attendanceML(String rollNumber,String date,String status)
    {
        UpdateInDB updateInDBObj =new UpdateInDB();
        updateInDBObj.update("INSERT INTO Attendance(RollNumber,Date,Status) VALUES('" + rollNumber + "','" + date + "','" + status + "')");
    }

    public boolean isAttendanceHistoryAvailable(String date)
    {
        String query="SELECT EXISTS(SELECT * FROM Attendance WHERE Date='"+date+"') AS res";
        return IsExistsInDB.isExistsInDB(query);
    }

    public ResultSet getAttendanceHistory(String date)
    {
        String query="SELECT RollNumber,Date,Status FROM Attendance WHERE Date='"+date+"'";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }

    public boolean isRollNoAvailOnAttendance(String rollNo)
    {
        String query="SELECT EXISTS(SELECT * FROM Attendance WHERE RollNumber='"+rollNo+"') AS res";
        return IsExistsInDB.isExistsInDB(query);
    }

    public ResultSet getAttendanceHistoryByRollNo(String rollNo)
    {
        String query="SELECT RollNumber,Date,Status FROM Attendance WHERE RollNumber='"+rollNo+"'";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }


}