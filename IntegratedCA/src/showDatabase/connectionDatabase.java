/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package showDatabase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lucas dos Santos Barbosa
 */
public class ConnectionDatabase implements ConnectionDatabaseInterface {
    
    @Override
    public Connection createConnection(){
        
        String dbName = "rteplayer";
        String DB_URL = "jdbc:mysql://localhost:3306" + dbName;
        String USER = "root";
        String PASS = "root";
       
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
                Statement stmt = con.createStatement();
                
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM rteplayer.movies");
                
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }}
           
        } catch (SQLException e) {
            System.out.println("Connection error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
}
    
}
