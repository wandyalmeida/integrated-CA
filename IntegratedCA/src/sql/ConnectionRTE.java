/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Carolina Landim 2021226
 */
public class ConnectionRTE implements ConnectionRTEInterface{

    /*
        Connection Java with Database
    */
    
    @Override
    public Connection connectDB(){

        Connection connect = null;
       
        try {
            String dbName = "rteplayer";
            String DB_URL = "jdbc:mysql://localhost/" + dbName;
            String USER = "root";
            String PASS = "root";
            connect = DriverManager.getConnection("jdbc:mysql://localhost/", USER, PASS);
           
           
        } catch (SQLException e) {
            System.out.println("Error on the connection part " + e.getMessage());// show this message if this method get a error.
        }
        
        return connect;
    }    
    
}
