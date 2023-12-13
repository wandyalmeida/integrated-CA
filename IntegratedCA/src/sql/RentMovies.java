/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import UserGetSet.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carolina Landim 2021226
 */
public class RentMovies implements RentMoviesInterface{
    
    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    
    @Override
    public void rentMovies(User objuser){
        
        connect = new ConnectionRTE().connectDB();
        
        try{
            String sql = "SELECT DISTINCT a.movie_id, m.title, m.price FROM movie_chart a " +
                         "JOIN movies m ON a.movie_id = m.movie_id " +
                         "WHERE a.user_id = ? AND TIMESTAMPDIFF(MINUTE, a.rentDate, NOW()) < 1 " +
                         "ORDER BY a.movie_id ASC ";
            
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, objuser.getUserId());
            pstm.execute("USE rteplayer;");
            rs = pstm.executeQuery();
            
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("                                  USER'S RENTED MOVIES                                                  ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println( "|MOVIE ID  " + "  |TITLE  " + "\t                                                              |PRICE  ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            int rowcount = 0;
            while(rs.next()){ // Show table with the List of Movies and price

                int movie_id = rs.getInt("movie_id");
                String title = rs.getString("title");
                double price = rs.getDouble("price");
                                              
                  // Display each movie row organised
                System.out.printf("| %-10d | %-70s | €%-15.2f%n", movie_id, title, price);
                rowcount++;
            } 
            if(rowcount == 0){
                System.out.println("                                  NO RENTED MOVIES                                                  ");

            }
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            rs.close();
            
        }catch(SQLException e){
            
           System.out.println("Rent Movies error" + e);
        }
        
    }
}
