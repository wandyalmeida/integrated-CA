/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Carolina Landim
 * 
 * This class represent all attributes that will be used in another classes
 * in the sql packages
 */
public class Attributes {
    
   protected String SQL_COMMAND;
   protected  Connection connect = new ConnectionRTE().connectDB();
   protected  PreparedStatement pstm;
   protected  ResultSet rs;
   protected String database = "USE rteplayer";
    
    
          
        
    
    
}
