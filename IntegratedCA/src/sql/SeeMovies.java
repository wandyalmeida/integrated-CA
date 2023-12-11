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
public class SeeMovies implements SeeMoviesInterface {
    
    /*
    Show the movies table
    */
    @Override
    public void seeMovies(){
       
        /*
        Variables:
        
            int movie_id; 
            String title;
            double price;
            pstm = Prepare Statment.
            RS = ResultSet
            connection = Connection
            */
        
        String SQL_COMMAND;
        int movie_id; 
        String title;
        double price;
        Connection connect;
        PreparedStatement pstm;
        ResultSet rs;
        
        
        try {
            //This method will show the movies 
            SQL_COMMAND = "select * from movies ";//Get movies table
            connect = new ConnectionRTE().connectDB();
            pstm = connect.prepareStatement(SQL_COMMAND);
            
            pstm.execute("USE rteplayer;");
            rs = pstm.executeQuery();
            

            System.out.println( "|MOVIE ID  " + "  |TITLE  " + "\t                                                              |PRICE  ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            while(rs.next()){ // Show table with the List of Movies and price

                movie_id = rs.getInt("movie_id");
                title = rs.getString("title");
                price = rs.getDouble("price");
                                              
                  // Display each movie row 
                System.out.printf("| %-10d | %-70s | €%-15.2f%n", movie_id, title, price);
            } 
            
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
 

        } catch (SQLException e) {
            System.out.println("See Movies: " + e);// show this message if this method get a error.
        }
    }

    
}
