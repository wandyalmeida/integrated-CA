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
    
    @Override
    public void selectMovie(Movies objmovies){
        
        
        try{
            String sql = "SELECT * FROM movies WHERE movie_id = ?";
            
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, objmovies.getMovie_id());
            pstm.execute(database);
            
            // Execute the sql query and get the result set
            rs = pstm.executeQuery();
            // Check if there is a result 
            if(rs.next()){
                //if there is a result, retrieve title and price
                title = rs.getString("title");
                price = rs.getDouble("price");
                System.out.println("Title: " + title);
                System.out.println("Price: "+ price);
                
            }else{
                System.out.println("Movie not found!");
            }
            
            
            
        }catch (SQLException e){
            System.out.println("Error on SelectMovie " + e);
        }
        
    }
}
