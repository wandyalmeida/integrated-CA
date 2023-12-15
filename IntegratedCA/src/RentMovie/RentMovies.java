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
import java.util.InputMismatchException;


/**
 * @author Lucas dos Santos Barbosa
 * @author Wandwilson Almeida Da Silva 2021230
 */
public class RentMovies {
    /**
     * This class will Display to user to rent the movie and
     * collect some input from the user to rent the movie
     * and show the user the movies he rented all the movies will be rented by one day.
     * @param userID this is get the userID  that is coming from the user get and set.
     * @throws java.lang.InterruptedException
    **/
    Scanner userInput = new Scanner(System.in);
    Movies movie = new Movies();
    SelectMovie selectMovie = new SelectMovie();        
    int movieId, rentConfirm;
    ShowMenu menu = new  ShowMenu();
    InsertMovieChart moviechart = new InsertMovieChart();
       
    public void RentMovies(User userID) throws InterruptedException{
        // We use a do loop to check if the user is put an Integer to choose the movie by ID.
        do {
            System.out.println("Please enter the ID of the movie you would like to rent: ");
            try {
                movieId = userInput.nextInt();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                userInput.next(); // this ignore the old input of the user.
            }
        } while (true);// if everthing is ok they will start to do the other part of the code below.
            movie.setMovie_id(movieId);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Please can you confirm that you are renting this movie ");

            if (selectMovie.selectMovie(movie)){
                System.out.println("1: [Yes] \n2: [No]");
                rentConfirm = userInput.nextInt();//will get if the user will rent the movie or not.

                switch (rentConfirm){//check the input of the user/
                    case 1://show that user rented the movie.
                        System.out.println("Movie rented");
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        moviechart.InsertMovieChart(userID.getUserId(), movieId);// insert the movie rented on the DataBase.
                        menu.showMenu(userID); // Show the menu to check what the user want to do.
                        break;
                    case 2: // if the user do not want to rent the movie.
                        System.out.println("Movie not rented");
                        menu.showMenu(userID);// Show the menu to check what the user want to do.
                        break;
                    default:
                        System.out.println("Sorry wrong option. Try again..");// if the user put the worng option.
                        RentMovies(userID);// show the call again to use try to rent the movie.
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");


                }
            }
    }
}

