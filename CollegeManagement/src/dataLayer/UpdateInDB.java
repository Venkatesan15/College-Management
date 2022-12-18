package dataLayer;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateInDB {
    public void update(String query1)
    {
        try {

            Jdbc jdbcObj=new Jdbc();
            Connection con=jdbcObj.getConnection();
            Statement st=con.createStatement();
            st.executeUpdate(query1);

        }
        catch (Exception e)
        {

        }
    }
}
