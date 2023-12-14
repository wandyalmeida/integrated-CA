/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.ConnectionRTE;

/**
 *
 * @author Carolina Landim 2021226
 * 
 * This class it is to stored the most selected movies.
 * 
 */
public class Top5 implements Top5Interface {
    
    /*
    Methods command
    Connection 
    Prepared Statement 
    */
    String SQL_COMMAND;
    Connection connect;
    PreparedStatement pstm;
    
    @Override
    public void Top5(){
      try {
            connect = new ConnectionRTE().connectDB();
            pstm = connect.prepareStatement(SQL_COMMAND);
            // Check the top 5 movies in the database
            String query = "SELECT movies.title, movies.price, COUNT(movie_chart.movie_id) AS selections " +
                           "FROM movie_chart " +
                           "JOIN movies ON movie_chart.movie_id = movies.movie_id " +
                           "GROUP BY movie_chart.movie_id " +
                           "ORDER BY selections DESC " +
                           "LIMIT 5";

            PreparedStatement preparedStatement = connect.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
 
            // This will be the results of the top 5 of movies
            System.out.println("Top 5 Movies:");
            while (rs.next()) {
                String title = rs.getString("title");
                double price = rs.getDouble("price");
                int selections = rs.getInt("selections");

                System.out.println("Title: " + title + ", Price: " + price + ", Selections: " + selections);
            }
        } catch (SQLException e) {
            System.out.println("Error in Top 5 " + e);// Messsage error for this class
        }
    }
}
