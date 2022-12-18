package MiddleLayer;

import DataLayer.ResultSet;
import DataLayer.IsExistsInDB;
import DataLayer.UpdateInDB;

public class Complaints {
    public void sendQuery(String date,String rollNo,String comp)
    {
        String query="INSERT INTO Queries(Date,RollNo,Query) VALUES('"+date+"','"+rollNo+"','"+comp+"')";
        UpdateInDB updateInDBObj=new UpdateInDB();
        updateInDBObj.update(query);
    }
    public java.sql.ResultSet getQueries()
    {
        String query="SELECT * FROM Queries";
        ResultSet resultSetObj =new ResultSet();
        return resultSetObj.getResultSet(query);
    }
    public boolean isQueryAvailable()
    {
        String query="SELECT EXISTS(SELECT * FROM Queries)AS res";
        return IsExistsInDB.isExistsInDB(query);
    }
}
