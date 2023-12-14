/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carolina Landim 2021226
 */
public class GetUserID implements GetUserIDInterface{
    
    /*
    Methods command
    Connection to database 
    Prepared Statement to execute queries
    */
    
    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    
     @Override
    public int getId(String email, String password){
        String SQL_COMMAND = "SELECT * FROM users WHERE email = ? AND password = ?";

        int id_user = 0;
        
        
        try {
             /*
                Get user ID 
            */
            connect = new ConnectionRTE().connectDB();
            pstm = connect.prepareStatement(SQL_COMMAND);
            
            pstm.setString(1, email);//set the username to get the id
            pstm.setString(2, password);//set the password to get id
            
            pstm.execute("USE rteplayer;");
            rs = pstm.executeQuery();
            if(rs.next()){
                id_user = rs.getInt("user_id");//get the id from the user
                return id_user; 
                               
            }
        } catch (SQLException e) {
            System.out.println("Get ID: " + e);// show this message if this method get a error.
        }
        return id_user;
    }
    
}
