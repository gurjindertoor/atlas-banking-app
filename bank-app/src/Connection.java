import java.sql.*;

public class Connection {
    
    Connection c;
    public Connection() {
        try {
            Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///");

        } catch (Exception e){
            System.out.println(c);
        }
    }
}
