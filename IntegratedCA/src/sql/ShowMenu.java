/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.util.Scanner;
import sql.MovieMenu.MenuOption;

/**
 *
 * @author Lucas dos Santos Barbosa
 */
public class ShowMenu {
    
    //This method gets the input of the user and display a menu with two options
    public void showMenu(int userID) {
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
            
            if (userInput.matches("[1-2]")) {
                int choice = Integer.parseInt(userInput);
            //Switch with the values of options
            switch (options[choice]) {
                case SEE_MOVIES:
                    SeeMovies seeMovies = new SeeMovies();
                    seeMovies.seeMovies();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
            }
            
            }else {
                System.out.println("Sorry, this option is not valid\n");
            }
        }
    }
}
