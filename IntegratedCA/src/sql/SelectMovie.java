/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import ReadFile.Movies;
import java.sql.SQLException;

/**
 *
 * @author Carolina Landim 20212226
 */
public class SelectMovie extends Attributes implements SelectMovieInterface{
    
    // Variables
    String title;
    double price;
    int movie_id;
    
    @Override
    public boolean selectMovie(Movies objmovies){
        
        
        try{
            SQL_COMMAND = "SELECT * FROM movies WHERE movie_id = ?";
            
            pstm = connect.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, objmovies.getMovie_id());
            pstm.execute(database);
            
            // Execute the sql query and get the result set
            rs = pstm.executeQuery();
            // Check if there is a result 
            if(rs.next()){
                //if there is a result, retrieve movie_id, title and price
                movie_id = rs.getInt("movie_id");
                title = rs.getString("title");
                price = rs.getDouble("price");
                System.out.println("Movie ID: " + movie_id);
                System.out.println("Title: " + title);
                System.out.println("Price: " + price);
                return true;
                
            }else{
                System.out.println("Movie not found!");
                return false;
            }     
        }catch (SQLException e){
            System.out.println("Error on SelectMovie " + e);
        }
        return false;
    }
}
