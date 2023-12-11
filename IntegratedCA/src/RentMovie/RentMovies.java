/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentMovie;
import java.util.Scanner;
import sql.SeeMovies;
import sql.ShowMenu;


/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 */
public class RentMovies {
    /**
     * This class will Display to user to rent the movie and
     * collect some input from the user to rent the movie.
    **/
       
    public void RentMovies(){
        Scanner userInput = new Scanner(System.in);
        int movieId, rentConfirm;
//        SeeMovies movies = new SeeMovies();
        ShowMenu menu = new  ShowMenu();
        
        System.out.println("Please enter the ID of the movie you would like to rent");
        movieId = userInput.nextInt();
        
        System.out.println("Please can you confirm are you rent this movie " + movieId);
        System.out.println("1[Yes] \n2[No]");
        rentConfirm = userInput.nextInt();
        switch (rentConfirm){
            case 1:
                System.out.println("Movie rented");                 
                menu.showMenu(); 
                break;
            case 2:
                System.out.println("Movie not rented");
                menu.showMenu();
                break;
            default:
                System.out.println("Sorry wrong option. Try again..");
                RentMovies();
                
                
        }
    }
    
}
