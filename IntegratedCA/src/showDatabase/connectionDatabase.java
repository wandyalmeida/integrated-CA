/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package showDatabase;
import java.sql.*;
/**
 *
 * @author Lucas dos Santos Barbosa
 */
public class connectionDatabase {
    
     void createConnection() throws ClassNotFoundException {
        
       
        try {
            String dbName = "rteplayer";
            String DB_URL = "jdbc:mysql://localhost:3306/?user=root" + dbName;
            String USER = "root";
            String PASS = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
           
           
        } catch (SQLException e) {
            System.out.println("Connection error");
        }
        
    }
    
}
