/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import UserGetSet.User;


import java.sql.SQLException;

/**
 *
 * @author Carolina Landim 2021226
 * 
 * This class will execute the movies that users rent and give information about
 * date and time of the rent.
 */
public class RentMoviesDB extends Attributes implements RentMoviesDBInterface{
        
    @Override
    public void rentMoviesDB(User objuser){
        
        // SQL Commands 
        try{
            SQL_COMMAND = "SELECT DISTINCT a.movie_id, m.title, m.price FROM movie_chart a " +
                         "JOIN movies m ON a.movie_id = m.movie_id " +
                         "WHERE a.user_id = ? AND TIMESTAMPDIFF(MINUTE, a.rentDate, NOW()) < 1 " +
                         "ORDER BY a.movie_id ASC ";
            
            pstm = connect.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, objuser.getUserId());
            pstm.execute(database);
            rs = pstm.executeQuery();
            
            
            // Display the list of Rented movie if it is rented
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("                                  USER'S RENTED MOVIES                                                  ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println( "|MOVIE ID  " + "  |TITLE  " + "\t                                                              |PRICE  ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            int rowcount = 0;
            while(rs.next()){ // Show table with the List of Movies and price

                int movie_id = rs.getInt("movie_id");
                String title = rs.getString("title");
                double price = rs.getDouble("price");
                                              
                  // Display each movie row organised
                System.out.printf("| %-10d | %-70s | €%-15.2f%n", movie_id, title, price);
                rowcount++;
            } 
            // Display when there is no movies rented
            if(rowcount == 0){
                System.out.println("                                  NO RENTED MOVIES                                                  ");

            }
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            rs.close();
            
        }catch(SQLException e){
            
           System.out.println("Rent Movies error" + e);// Error message from Rent Movies class
        }
        
    }
}
