/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentMovie;
import ReadFile.Movies;
import java.util.Scanner;
import sql.InsertMovieChart;
import sql.SelectMovie;
import ShowMenu.ShowMenu;
import UserGetSet.User;


/**
 * @author Lucas dos Santos Barbosa
 * @author Wandwilson Almeida Da Silva 2021230
 */
public class RentMovies {
    /**
     * This class will Display to user to rent the movie and
     * collect some input from the user to rent the movie.
    **/
       
    public void RentMovies(User userID) throws InterruptedException{
        Scanner userInput = new Scanner(System.in);
        int movieId, rentConfirm;
        ShowMenu menu = new  ShowMenu();
        
        System.out.println("Please enter the ID of the movie you would like to rent: ");
        movieId = userInput.nextInt();
        Movies movie = new Movies();
        movie.setMovie_id(movieId);
        SelectMovie selectMovie = new SelectMovie();        
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Please can you confirm that you are renting this movie ");
        
        if (selectMovie.selectMovie(movie)){
            System.out.println("1: [Yes] \n2: [No]");
            rentConfirm = userInput.nextInt();
            
            switch (rentConfirm){
                case 1:
                    System.out.println("Movie rented");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    InsertMovieChart moviechart = new InsertMovieChart();
                    moviechart.InsertMovieChart(userID.getUserId(), movieId);
                    menu.showMenu(userID); 
                    break;
                case 2:
                    System.out.println("Movie not rented");
                    menu.showMenu(userID);
                    break;
                default:
                    System.out.println("Sorry wrong option. Try again..");
                    RentMovies(userID);


            }
        }
    }
}
