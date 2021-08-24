package database;
import java.sql.*;

public class Data {
    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection c=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\39346\\OneDrive\\Desktop\\prova.db");
        Statement s=c.createStatement();
        ResultSet r=s.executeQuery("select * from user");
        String a=r.getString(1);
        System.out.println(a);
        s.close();
        c.close();

    }

}
