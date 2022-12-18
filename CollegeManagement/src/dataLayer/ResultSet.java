package dataLayer;

import java.sql.Connection;
import java.sql.Statement;

public class ResultSet {
    public java.sql.ResultSet getResultSet(String query)
    {
        try {
            Jdbc jdbcObj=new Jdbc();
            Connection con=jdbcObj.getConnection();
            Statement st=con.createStatement();
            java.sql.ResultSet rs=st.executeQuery(query);
            return rs;

        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
