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

//connection between java and mySQL
public class CnnectionDatabase implements ConnectionDatabaseInterface {
    
    @Override
    public Connection createConnection(){
        
        String dbName = "rteplayer";
        String DB_URL = "jdbc:mysql://localhost:3306/" + dbName;
        String USER = "root";
        String PASS = "root";
       
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
                
                Statement stmt = con.createStatement();
                
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM movies");
                
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(2));
                }}
           
        } catch (SQLException e) {
            System.out.println("Connection error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CnnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
}
    
}
