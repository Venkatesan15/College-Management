package MiddleLayer;

import DataLayer.GetResultSet;

import java.sql.ResultSet;

public class GetName {
    public ResultSet getName()
    {
        GetResultSet getResultSetObj =new GetResultSet();
        return getResultSetObj.getResultSet("SELECT RollNumber,Name FROM StudentsDetails");
    }
}
