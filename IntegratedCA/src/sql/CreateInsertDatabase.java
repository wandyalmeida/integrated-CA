/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carolina Landim 2021226
 */
public class CreateInsertDatabase extends Attributes implements CreateInsertDatabaseInterface {
       
    /*
      Start creating schema on database
    */
    @Override
    public boolean create_schema(){
        try {
           Statement stmt = connect.createStatement();
           
            //check if the data base have this schema. if no they will create the schema.
            stmt.execute("CREATE SCHEMA IF NOT EXISTS rteplayer;");
            stmt.execute(database);
            
            /*
            Create tables on the Database
            
            First Table: Users 
            
            user_id INT(20) PRIMARY KEY AUTO_INCREMENT,
            name VARCHAR(30),
            surname VARCHAR(30),
            email VARCHAR(100),
            password VARCHAR(20);
            */

            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS users  ("
                            + "user_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "name VARCHAR(30),"
                            + "surname VARCHAR(30),"
                            + "email VARCHAR(100),"
                            + "password VARCHAR(20));"
            );
            
            /*
            Second Table: Movies
            
            movie_id INT(20) PRIMARY KEY AUTO_INCREMENT,
            name VARCHAR(80),
            price DOUBLE(20),
            */
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS movies ("
                            + "movie_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "title VARCHAR(80),"
                            + "price DOUBLE(20,2));"               
            );
            
            /*
            Third Table: Movie Chart
            
            moviechart_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
            user_id INT(20) NOT NULL,
            movie_id INT(20) NOT NULL;
            */
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS movie_chart  ("
                            + "moviechart_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "user_id INT(20) NOT NULL,"
                            + "movie_id INT(20) NOT NULL,"
                            + "rentDate TIMESTAMP,"
                            + "CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,"
                            + "CONSTRAINT fk_movie FOREIGN KEY (movie_id) REFERENCES movies(movie_id) ON DELETE CASCADE ON UPDATE CASCADE);"
                            
            );

           
            return true;
        } catch (SQLException e) {
            System.out.println("Create Schema and Tables: " + e);// show this message if this method get a error.
            return false; // return false if the data base is ready created.
        }
    }
        
}
