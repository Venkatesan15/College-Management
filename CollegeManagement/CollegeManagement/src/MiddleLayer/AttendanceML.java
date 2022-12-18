package MiddleLayer;

import DataLayer.ResultSet;
import DataLayer.IsExistsInDB;
import DataLayer.UpdateInDB;

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

    public java.sql.ResultSet getAttendanceHistory(String date)
    {
        String query="SELECT RollNumber,Date,Status FROM Attendance WHERE Date='"+date+"'";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }

    public boolean isRollNoAvailOnAttendance(String rollNo)
    {
        String query="SELECT EXISTS(SELECT * FROM Attendance WHERE RollNumber='"+rollNo+"') AS res";
        return IsExistsInDB.isExistsInDB(query);
    }

    public java.sql.ResultSet getAttendanceHistoryByRollNo(String rollNo)
    {
        String query="SELECT RollNumber,Date,Status FROM Attendance WHERE RollNumber='"+rollNo+"'";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }


}