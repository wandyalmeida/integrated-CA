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
 * @author carol
 */
public class SelectMovie implements SelectMovieInterface{
    
    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    String title;
    double price;
    
    @Override
    public void selectMovie(Movies objmovies){
        
        connect = new ConnectionRTE().connectDB();
        
        try{
            String sql = "select * from movies where movie_id = ?";
            
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, objmovies.getMovie_id());
            pstm.execute("use rteplayer;");
            
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
