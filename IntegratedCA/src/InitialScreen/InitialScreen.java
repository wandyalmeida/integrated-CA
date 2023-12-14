package InitialScreen;

import Login.Login;
import SignUp.SignUp;
import java.util.Scanner;

/**
 *
 * @author Charles Rocha
 */
public class InitialScreen implements InitialScreenInterface {

    Scanner firstUserInput = new Scanner(System.in);
    Login loginCheck;
    SignUp signUpScreen;

    @Override
    public void initialScreen() {
        try {

            loginCheck = new Login();
            signUpScreen = new SignUp();

            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            System.out.println("Welcome to  ÉirVid!\nIt is a pleasure to have you here!");
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

            System.out.println("Select your option:");
            System.out.println("Please select only numbers");
            System.out.println("1 - Login\n2 - SignUp");

            String option = firstUserInput.next();

            switch (option) {
                case "1":
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    loginCheck.login();
                case "2":
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    signUpScreen.SignUpUser();
                    initialScreen();
                default:
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Sorry, wrong option... Try again.");
                    initialScreen();

            }

        } catch (Exception e) {
            System.out.println("Error initial Screen: " + e);
        }

    }

}
