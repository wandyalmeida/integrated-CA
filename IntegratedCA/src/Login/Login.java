package Login;

import InitialScreen.InitialScreen;
import UserGetSet.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import sql.Authentication;
import sql.GetUserID;
import sql.SeeMovies;
import ShowMenu.ShowMenu;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.Top5;

/**
 *
 * @author Charles Rocha 2021376
 * This class will collect the information inserted by the user and check if it exists on Database
 * Through the Authentication, if it exists, the user will be able to see the rent movies menu
 * if not it will show a message of invalid email, invalid password, 
 * and after the third time the user will must wait to try again
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

    //login() will try to connect to Database
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

                //Authenticator from database
                rs = userAutentication.autenticationUesr(registeredUser);
                int userId = user.getId(email, password);
                registeredUser.setUserId(userId);
                attempts--;
                if (rs.next()) {
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Sign In Successful");

                    //Once it is logged, it will show the 5 recommendations
                    recommendation.Top5();
                    TimeUnit.SECONDS.sleep(3);

                    movies.seeMovies();

                    menu.showMenu(registeredUser);
                    
                    //No success to connect, then:
                } else {
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Email or password is invalid.");
                }

                //User must wait
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
