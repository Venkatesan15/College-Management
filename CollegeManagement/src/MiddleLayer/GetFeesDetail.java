package MiddleLayer;

import DataLayer.GetResultSet;
import DataLayer.IsExistsInDB;

import java.sql.ResultSet;

public class GetFeesDetail {
    public ResultSet getFeesDetail()
    {
        String query="SELECT Particulars,Amount,LastDate FROM FixedFeesDetails";
        GetResultSet getResultSetObj=new GetResultSet();
        return getResultSetObj.getResultSet(query);
    }
    public boolean isParticularAvailable()
    {
        String query="SELECT EXISTS(SELECT * FROM FixedFeesDetails) AS res";
        return IsExistsInDB.isExistsInDB(query);
    }
}
