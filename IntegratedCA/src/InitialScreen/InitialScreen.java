package InitialScreen;

import Enum.EnumStart;
import Login.Login;
import SignUp.SignUp;
import java.util.Scanner;

/**
 *
 * @author Charles Rocha
 * This class shows the first screen to the user
 * Then the user has the option to login if already has  a login or sign Up to create a login
 * Once it is logged, it will show a menu
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

            /*
             * Show the enum menu
             */
            for (int type = 1; type <= EnumStart.values().length; type++) {
                System.out.println(type + ". " + EnumStart.values()[type - 1]);
            }
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            
            System.out.println("Select your option:");
            System.out.println("Please select only numbers");
            
            String option = firstUserInput.next();
            
            switch (option) {
                case "1":
                    loginCheck.login();
                    break;
                case "2":
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    signUpScreen.SignUpUser();
                    initialScreen();
                    break;
                case "3":
                    System.out.println("Thank you for coming! See you soon.");
                    System.exit(0);
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
