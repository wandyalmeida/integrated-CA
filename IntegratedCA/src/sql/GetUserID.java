/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.SQLException;

/**
 *
 * @author Carolina Landim 2021226
 */
public class GetUserID extends Attributes implements GetUserIDInterface{
    @Override
    public int getId(String email, String password){
        SQL_COMMAND = "SELECT * FROM users WHERE email = ? AND password = ?";

        int id_user = 0;
        
        
        try {
             /*
                Get user ID 
            */
            pstm = connect.prepareStatement(SQL_COMMAND);
            
            pstm.setString(1, email);//set the username to get the id
            pstm.setString(2, password);//set the password to get id
            
            pstm.execute(database);
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
