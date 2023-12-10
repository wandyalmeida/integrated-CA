/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.util.Scanner;
import sql.MovieMenu.MenuOption;

/**
 *
 * @author revol
 */
public class ShowMenu {
    
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        MenuOption[] options = MenuOption.values();

        while (true) {
            System.out.println("Please select an option:");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i].getOption());
            }

            int choice = scanner.nextInt();
            if (choice == options.length + 1) {
                break;
            }

            switch (options[choice - 1]) {
                case SEE_MOVIES:
                    SeeMovies seeMovies = new SeeMovies();
                    seeMovies.seeMovies();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
    
}
