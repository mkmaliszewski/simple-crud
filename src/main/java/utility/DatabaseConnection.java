package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static String URL;
    private static String user;
    private static String password;
    
    public static Connection getConnection(){
        if (connection != null){
            return connection;
        }
        
        URL = "jdbc:postgresql://localhost:5432/MyDatabase";
        user = "postgres";
        password = "admin123";
        
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return connection;
    }
}