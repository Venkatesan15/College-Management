package DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetResultSet {
    public ResultSet getResultSet(String query)
    {
        try {
            Jdbc jdbcObj=new Jdbc();
            Connection con=jdbcObj.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            return rs;

        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
