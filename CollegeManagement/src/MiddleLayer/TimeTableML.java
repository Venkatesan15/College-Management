package MiddleLayer;

import DataLayer.GetResultSet;
import DataLayer.IsExistsInDB;
import DataLayer.UpdateInDB;

import java.sql.ResultSet;

public class TimeTableML {
    public boolean isDayOrderAvailable(int dO)
    {
        String query="SELECT EXISTS(SELECT * FROM TimeTable where DayOrder='"+dO+"') AS res";
        return IsExistsInDB.isExistsInDB(query);
    }
    public void editUsingDayOrder(int dO, String f, String s, String t, String fo)
    {
        String query="UPDATE TimeTable SET FirstPeriod='"+f+"',SecondPeriod='"+s+"',ThirdPeriod='"+t+"',FourthPeriod='"+fo+"'  WHERE DayOrder='"+dO+"'";
        UpdateInDB updateInDBObj = new UpdateInDB();
        updateInDBObj.update(query);
    }
    public void insertIntoTimeTable(int dO,String f,String s,String t,String fo)
    {
        String query="INSERT INTO TimeTable(DayOrder,FirstPeriod,SecondPeriod,ThirdPeriod,FourthPeriod) VALUES('"+dO+"','"+f+"','"+s+"','"+t+"','"+fo+"')";
        UpdateInDB updateInDBObj = new UpdateInDB();
        updateInDBObj.update(query);
    }
    public void deleteTimeTable()
    {
        String query="TRUNCATE TABLE TimeTable";
        UpdateInDB updateInDBObj = new UpdateInDB();
        updateInDBObj.update(query);
    }
    public ResultSet getTimeTable()
    {
        String query="SELECT * FROM TimeTable";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }
}
