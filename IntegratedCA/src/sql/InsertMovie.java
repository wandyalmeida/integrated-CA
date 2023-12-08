/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import ReadFile.Movies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sql.ConnectionRTE;

/**
 *
 * @author Carolina Landim 2021226
 */
public abstract class InsertMovie implements InsertMovieInterface {
    
    Connection connect;
    PreparedStatement pstm;
    /* 
        Insert the movie titles and prices on the DataBase.
    */

    @Override
    public void InsertMovie(Movies objgetmovie){
       
       String SQL_COMMAND = "insert into movies (title , price ) values (?, ?)";// insert the new name movie and price on the DataBase.

        connect = new ConnectionRTE().connectDB();

        try {
            /*
            Statement for collecting data from document that will give the 
            required information : movie title and price.
            */
            pstm = connect.prepareStatement(SQL_COMMAND);
            pstm.setString(1, objgetmovie.getTitle());// set and get the movie.
            pstm.setDouble(2, objgetmovie.getPrice());// set and get the price.
            
            pstm.execute("USE rteplayer;");
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Get Movie: " + e);
        }
    }

    
}
