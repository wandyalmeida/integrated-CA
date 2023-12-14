/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import UserGetSet.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carolina Landim 2021226
 */
public class Authentication extends Attributes implements AuthenticationInterface{
     
    // Analise and if it is correct, authenticated user in database
    
     @Override
    public ResultSet autenticationUesr(User objUserRTE) {
        
        try {
            
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            
            
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, objUserRTE.getEmail());
            pstm.setString(2, objUserRTE.getPassword());
            
           
            pstm.execute(database);
            ResultSet rs = pstm.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.out.println("Autentication: " + e);// Autentication Error message.
            return null;
        }
    }
}
