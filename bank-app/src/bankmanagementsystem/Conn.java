package bankmanagementsystem;

import java.sql.*;

public class Conn {
    
    Connection conn;
    Statement s;
    
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Koda031402@");
            s = conn.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}