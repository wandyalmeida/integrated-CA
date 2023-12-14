/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.SQLException;
/**
 *
 * @author Carolina Landim 2021226
 * 
 * This class it is to stored the most selected movies.
 * 
 */
public class Top5 extends Attributes implements Top5Interface {
    
    @Override
    public void Top5(){
      try {
            // Check the top 5 movies in the database
            SQL_COMMAND = "SELECT a.movie_id, COUNT(*) AS selections, m.title, m.price " +
                           "FROM movie_chart a " +
                           "JOIN movies m ON a.movie_id = m.movie_id " +
                           "GROUP BY a.movie_id " +
                           "ORDER BY selections DESC " +
                           "LIMIT 5";
            
            // Execute the sql query and get the result set
            pstm = connect.prepareStatement(SQL_COMMAND);
            pstm.execute(database);
            rs = pstm.executeQuery();
 
            // This will be the results of the top 5 of movies
            if (rs.next()) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("                                  TOP 5 MOVIES                                                  ");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println( "|MOVIE ID  " + "  |TITLE  " + "\t                                                              |PRICE  ");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            
                do{
                    int movie_id = rs.getInt("movie_id");
                    String title = rs.getString("title");
                    double price = rs.getDouble("price");
                    
                    //Display Top 5
                    System.out.printf("| %-10d | %-70s | €%-15.2f%n", movie_id, title, price);
                }while(rs.next());
                
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            
            }
        } catch (SQLException e) {
            System.out.println("Error in Top 5 " + e);// Messsage error for this class
        }
    }
}
