package middleLayer;

import dataLayer.ResultSet;
import dataLayer.IsExistsInDB;
import dataLayer.UpdateInDB;
import uiLayer.TimeTableCl;

public class TimeTableML {
    public boolean isDayOrderAvailable(int dO)
    {
        String query="SELECT EXISTS(SELECT * FROM TimeTable where DayOrder='"+dO+"') AS res";
        return IsExistsInDB.isExistsInDB(query);
    }
    public void editUsingDayOrder(TimeTableCl ttObj)
    {
        String query="UPDATE TimeTable SET FirstPeriod='"+ttObj.getFirstPeriod()+"',SecondPeriod='"+ttObj.getSecondPeriod()+"',ThirdPeriod='"+ttObj.getThirdPeriod()+"',FourthPeriod='"+ttObj.getFourthPeriod()+"'  WHERE DayOrder='"+ttObj.getDayOrder()+"'";
        UpdateInDB updateInDBObj = new UpdateInDB();
        updateInDBObj.update(query);
    }
    public void insertIntoTimeTable(TimeTableCl timeTableClObj)
    {
        String query="INSERT INTO TimeTable(DayOrder,FirstPeriod,SecondPeriod,ThirdPeriod,FourthPeriod) VALUES('"+timeTableClObj.getDayOrder()+"','"+timeTableClObj.getFirstPeriod()+"','"+timeTableClObj.getSecondPeriod()+"','"+timeTableClObj.getThirdPeriod()+"','"+timeTableClObj.getFourthPeriod()+"')";
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
