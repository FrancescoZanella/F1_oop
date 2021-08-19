package database;
import java.sql.*;

public class Data {
    public static void main(String[] args) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection c=DriverManager.getConnection("jdbc:sqlserver://localhost;integratedSecurity=true");
        Statement s=c.createStatement();
        ResultSet r=s.executeQuery("select * from persona");
        String a=r.getString(2);
        System.out.println(a);
        s.close();
        c.close();

    }

}
