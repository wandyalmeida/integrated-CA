package InitialScreen;

import Login.Login;
import SignUp.SignUp;
import java.util.Scanner;

/**
 *
 * @author Charles Rocha
 */
public class InitialScreen implements InitialScreenInterface {
    
        Scanner userInput = new Scanner(System.in);
        Login loginCheck = new Login();
        SignUp signUpScreen = new SignUp();
        
    
        @Override
        public void initialScreen() {
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("Welcome to  ÉirVid!\nIt is a pleasure to have you here!");
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        
        System.out.println("Select your option:");
        System.out.println("Please select only numbers");
        System.out.println("1 - Login\n2 - SignUp");
        
        String option = userInput.next();        
        
        switch(option){
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

    }    
    
}
