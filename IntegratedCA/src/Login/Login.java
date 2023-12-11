package Login;

import InitialScreen.InitialScreen;
import SignUp.SignUp;
import UserGetSet.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import sql.Authentication;
import sql.ConnectionRTE;
import sql.SeeMovies;
import sql.ShowMenu;

/**
 *
 * @author Charles Rocha 2021376
 */
public class Login implements LoginInterface {

    Scanner userInput = new Scanner(System.in);
    InitialScreen firstScreen = new InitialScreen();
    Connection connect;
    
    //    SignUp menuSignUp = new SignUp();

    @Override
    public void login() {
        try {
            connect = new ConnectionRTE().connectDB();
            String email, password;
            //int userId;
            ResultSet rs;

            do {
                System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                System.out.println("Email: ");
                email = userInput.next();
                System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                System.out.println("Password: ");
                password = userInput.next();

                User registeredUser = new User();
                registeredUser.setEmail(email);
                registeredUser.setPassword(password);

                Authentication userAutentication = new Authentication();
                rs = userAutentication.autenticationUesr(registeredUser);

                if (rs.next()) {
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Sign In Successful");
                    
                    SeeMovies movies = new SeeMovies();
                    
                    movies.seeMovies();
                    
                    ShowMenu menu = new  ShowMenu();
                    menu.showMenu();                    
                    
                } else {
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Username or password is invalid.");
                    firstScreen.initialScreen();
//                    break;
                }

            } while (!rs.next());

        } catch (SQLException e) {
            System.out.println("Error in login " + e);
        }
    }

    @Override
    public void user(int userId) {

    }

}
