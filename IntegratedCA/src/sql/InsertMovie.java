/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import ReadFile.Movies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.ConnectionRTE;

/**
 *
 * @author Carolina Landim 2021226
 */
public class InsertMovie implements InsertMovieInterface {
    
    Connection connect;
    PreparedStatement pstm;
    /* 
    *   Insert all the movie titles and prices on the DataBase.
    */

    @Override
    public void InsertMovie(ArrayList<Movies> objgetmovie){
       
       String SQL_COMMAND = "INSERT INTO movies (title , price ) VALUES (?, ?)";// insert the new name movie and price on the DataBase.

        connect = new ConnectionRTE().connectDB();

        try {
            /*
            Statement for collecting data from document that will give the 
            required information : movie title and price.
            */
            connect.createStatement().execute("USE rteplayer;");
            pstm = connect.prepareStatement(SQL_COMMAND);
            for (Movies movie : objgetmovie) {
                pstm.setString(1, movie.getTitle());// set and get the movie.
                pstm.setDouble(2, movie.getPrice());// set and get the price.
                pstm.addBatch();
            }
            pstm.executeBatch(); // Execute once a list of movies           
            
        } catch (SQLException e) {
            System.out.println("Insert Movie: " + e);
        }
    }
    
}
