package Login;

import InitialScreen.InitialScreen;
import UserGetSet.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import sql.Authentication;
import sql.GetUserID;
import sql.SeeMovies;
import Enum.ShowMenu;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.Top5;

/**
 *
 * @author Charles Rocha 2021376
 */
public class Login implements LoginInterface {

    Authentication userAutentication = new Authentication();
    Scanner userInput = new Scanner(System.in);
    InitialScreen firstScreen = new InitialScreen();
    SeeMovies movies = new SeeMovies();
    ShowMenu menu = new ShowMenu();
    GetUserID user = new GetUserID();
    User registeredUser = new User();
    Top5 recommendation = new Top5();
    String email, password;
    ResultSet rs;
    int attempts = 3;

    @Override
    public void login() {
        try {

            do {
                System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                System.out.println("Email: ");
                email = userInput.next();
                System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                System.out.println("Password: ");

                password = userInput.next();

                registeredUser.setEmail(email);
                registeredUser.setPassword(password);

                rs = userAutentication.autenticationUesr(registeredUser);
                int userId = user.getId(email, password);
                registeredUser.setUserId(userId);
                attempts--;
                if (rs.next()) {
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Sign In Successful");

                    recommendation.Top5();
                    TimeUnit.SECONDS.sleep(3);

                    movies.seeMovies();

                    menu.showMenu(registeredUser);
                } else {
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Email or password is invalid.");
                }

            } while (!(rs.next()) && (attempts >= 1));
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            System.out.println("You have been sign out. \nYou must wait 10 seconds to try again.");
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            TimeUnit.SECONDS.sleep(10);

            firstScreen.initialScreen();

        } catch (SQLException e) {
            System.out.println("Error in login " + e);
        } catch (InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
