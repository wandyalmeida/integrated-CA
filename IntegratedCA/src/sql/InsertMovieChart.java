/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Carolina Landim 2021226
 */
public class InsertMovieChart implements InsertMovieChartInterface {
    
    Connection connect;
    PreparedStatement pstm;
    
    @Override
    public void InsertMovieChart(int user_id, int movie_id){
     String SQL_COMMAND = "insert into movie_chart (user_id , movie_id, rentDate ) values (?, ?, CURRENT_TIMESTAMP)";// insert the user id and movie id on table Movie Chart.
     
      connect = new ConnectionRTE().connectDB();

        try {
            /*
            Statement for collecting data from document that will give the 
            required information : user id and movie id.
            */
            connect.createStatement().execute("USE rteplayer;");
            pstm = connect.prepareStatement(SQL_COMMAND);
           
            pstm.setInt(1, user_id);// set and get user id.
            pstm.setInt(2, movie_id);// set and get movie id.
            pstm.execute();
            
                       
            
        } catch (SQLException e) {
            System.out.println("Insert Movie Chart: " + e);
        }
    }
}

