/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import UserGetSet.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Carolina Landim 2021226
 */
public class SignUpClass implements SignUpClassInterface{
    
    Connection connect;
    PreparedStatement pstm;
    /*
        
        insert the new Users on the DataBase.
    */

    @Override
    public void Sign_Up(User objsign_up){
       
       String SQL_COMMAND = "insert into  users ( email, password, name, surname) values (?, ?, ?, ?)";// insert the new user on the DataBase.

        connect = new ConnectionRTE().connectDB();

        try {
            /*
            Statement for collecting data from Sign up of users
            */
            pstm = connect.prepareStatement(SQL_COMMAND);
            pstm.setString(1, objsign_up.getEmail());// set and get the email.
            pstm.setString(2, objsign_up.getPassword());// set and get the password.
            pstm.setString(3, objsign_up.getName());// set and get the name.
            pstm.setString(4, objsign_up.getSurname());// set and get the surname.
            
            pstm.execute("USE rteplayer;");
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Sign UP User: " + e);
        }
    }
}
