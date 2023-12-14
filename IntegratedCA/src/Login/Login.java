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
    String email, password;
    ResultSet rs;

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

                if (rs.next()) {
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Sign In Successful");

                    movies.seeMovies();

                    menu.showMenu(userId);

                } else {
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Email or password is invalid.");
                    firstScreen.initialScreen();
                }

            } while (!rs.next());

        } catch (SQLException e) {
            System.out.println("Error in login " + e);
        }
    }
}
