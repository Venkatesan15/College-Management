package MiddleLayer;

import DataLayer.GetResultSet;
import DataLayer.IsExistsInDB;

import java.sql.ResultSet;

public class GetQueries {
    public ResultSet getQueries()
    {
        String query="SELECT * FROM Queries";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }
    public boolean isQueryAvailable()
    {
        String query="SELECT EXISTS(SELECT * FROM Queries)AS res";
        return IsExistsInDB.isExistsInDB(query);
    }
}
