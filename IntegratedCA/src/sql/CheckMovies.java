/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import ReadFile.Movies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Carolina Landim 2021226
 */
public class CheckMovies implements CheckMoviesInterface {
    
    //variables
    
    Connection connect;
    ResultSet rs;
    PreparedStatement pstm;
    
   
   // Check the movies name in the csv file it is in Database 
  public boolean CheckMovies(Movies movieName){
      connect = new ConnectionRTE().connectDB();
      
        String SQL_COMMAND = "SELECT COUNT(*) as count FROM movies WHERE name = ?";
        try {
            pstm = connect.prepareStatement(SQL_COMMAND);
            pstm.setString(1, movieName.getTitle());
            pstm.execute("USE rteplayer;");
            pstm.execute();
            rs = pstm.executeQuery();
            rs.next();
            return rs.getInt(1)>0;
            
            
        }catch(SQLException e){
            System.out.println("Check Movies error " + e);
            return false;
            
        // Close the resources in the finally block to ensure it always close
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                 System.out.println("Check close resources error " + e);
                
            }
        }
    }  
      
}
