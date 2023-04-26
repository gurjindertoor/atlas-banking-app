package bankmanagementsystem;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // CHANGE 1ST "root" TO YOUR USER AND 2ND "root" TO YOUR PASSWORD IN MYSQL WORKBENCH
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");
            s = c.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}