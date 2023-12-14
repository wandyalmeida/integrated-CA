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
import java.util.ArrayList;



/**
 *
 * @author Carolina Landim 2021226
 * 
 * This class it is project to confirm the movies in database 
 * is the same as in the csv file.
 */
public class CheckMovies implements CheckMoviesInterface {
    
    /*
    Methods command
    Connection 
    Prepared Statement 
    */
    
    Connection connect;
    ResultSet rs;
    PreparedStatement pstm;
    
   
  // Check the movies title in the csv file it is in Database 
    @Override
    public boolean CheckMovies(ArrayList<Movies> movieName){
         connect = new ConnectionRTE().connectDB();

           String SQL_COMMAND = "SELECT COUNT(*) as count FROM movies WHERE title = ?";
           try {
               for (Movies movie : movieName) {
               pstm = connect.prepareStatement(SQL_COMMAND);
               pstm.setString(1, movie.getTitle());
               pstm.execute("USE rteplayer;");
               pstm.execute();
               rs = pstm.executeQuery();
               rs.next();

               if (rs.getInt(1) == 0) {
                   // If count is 0, movie is not in the database
                   return false;
               }
           }

           // If no movie is found not in the database, return true
           return true;
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
                    System.out.println("Check close resources error " + e);// Check Movies Error

               }
           }
       }
      
}
