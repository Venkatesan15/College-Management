package middleLayer;

import dataLayer.ResultSet;
import dataLayer.IsExistsInDB;
import dataLayer.UpdateInDB;
import uiLayer.Complaint;

public class Complaints {
    public void sendQuery(Complaint complaintObj)
    {
        String query="INSERT INTO Queries(Date,RollNo,Query) VALUES('"+complaintObj.getDate()+"','"+complaintObj.getRollNumber()+"','"+complaintObj.getQuery()+"')";
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
