package MiddleLayer;

import DataLayer.UpdateInDB;

public class SendQueryML {
    public void sendQuery(String date,String rollNo,String comp)
    {
        String query="INSERT INTO Queries(Date,RollNo,Query) VALUES('"+date+"','"+rollNo+"','"+comp+"')";
        UpdateInDB updateInDBObj=new UpdateInDB();
        updateInDBObj.update(query);
    }
}

