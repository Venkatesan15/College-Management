package middleLayer;

import dataLayer.ResultSet;
import dataLayer.IsExistsInDB;
import dataLayer.UpdateInDB;

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
    public java.sql.ResultSet getTimeTable()
    {
        String query="SELECT * FROM TimeTable";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }
}
