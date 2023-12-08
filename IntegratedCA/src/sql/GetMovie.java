/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import UserGetSet.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sql.ConnectionRTE;

/**
 *
 * @author carol
 */
public class GetMovie implements GetMovieInterface {
      Connection connect;
    PreparedStatement pstm;
    /* 
        Insert the Movies and prices on the DataBase.
    */

    @Override
    public void GetMovie(User objgetmovie){
       
       String SQL_COMMAND = "insert into Movies (movie , price (?, ?)";// insert the new movie and price on the DataBase.

        connect = new ConnectionRTE().connectDB();

        try {
            /*
            Statement for collecting data from document that will give the 
            required information : movie and price.
            */
            pstm = connect.prepareStatement(SQL_COMMAND);
            pstm.setString(1, objgetmovie.getMovie());// set and get the movie.
            pstm.setString(2, objgetmovie.getPrice());// set and get the price.
            
            pstm.execute("USE rteplayer;");
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Get Movie: " + e);
        }
    }
    
}
