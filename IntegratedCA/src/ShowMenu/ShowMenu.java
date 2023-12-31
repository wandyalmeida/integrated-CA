/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShowMenu;

import java.util.Scanner;
import Enum.MovieMenu.MenuOption;
import InitialScreen.InitialScreen;
import RentMovie.RentMovies;
import UserGetSet.User;
import java.util.concurrent.TimeUnit;
import sql.RentMoviesDB;
import sql.SeeMovies;
import sql.Top5;


/**
 *
 * @author Lucas dos Santos Barbosa - 2021337
 */
public class ShowMenu implements ShowMenuInterface{
    
    //This method gets the input of the user and display a menu with two options
    @Override
    public void showMenu(User userID) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        MenuOption[] options = MenuOption.values();
        
        //Presenting the menu to the user
        while (true) {
            System.out.println("Please select an option:");
            
            //Loop to print the options
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i].getOption());
            }
            
            //reading the user input
            String userInput = scanner.nextLine();
            
            if (userInput.matches("[1-3]")) {
                int choice = Integer.parseInt(userInput);
            //Switch with the values of options
            switch (choice) {
                case 1:
                    SeeMovies seeMovies = new SeeMovies();
                    Top5 top5 = new Top5();
                    top5.Top5();
                    TimeUnit.SECONDS.sleep(1);
                    seeMovies.seeMovies();
                    RentMovies rent = new RentMovies();
                    rent.RentMovies(userID);
                    break;
                case 2:
                    RentMoviesDB rentMovies = new RentMoviesDB();
                    rentMovies.rentMoviesDB(userID);
                    break;
                case 3:
                    InitialScreen start = new InitialScreen();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Bye see you soon!");
                    start.initialScreen();
                    break;
                default:
                    System.out.println("Sorry, this option is not valid");
                    showMenu(userID);
            }
            
            }else {
                System.out.println("Sorry, this option is not valid\n");
                showMenu(userID);
            }
        }
    }
}
