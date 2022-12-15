package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
    public static Connection con;
    public Jdbc(){
        try
        {
            String url = "jdbc:mysql://localhost:3306/CollegeManagement";
            String un = "root";
            String pass = "Jayaramang@1";
            con = DriverManager.getConnection(url, un, pass);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
