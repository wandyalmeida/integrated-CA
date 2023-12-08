package Login;

import SignUp.SignUp;
import UserGetSet.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import sql.Authentication;
import sql.ConnectionRTE;

/**
 *
 * @author Charles Rocha 2021376
 */
public class Login implements LoginInterface {
    
    Scanner userInput = new Scanner (System.in);
    SignUp menuSignUp = new SignUp();
    Connection connect;

    @Override
    public void login() {
        System.out.println("");
        try{
            connect = new ConnectionRTE().connectDB();
            String email, password;
            //int userId;
            ResultSet rs;

            do{
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
                    initialScreen();
               }
                else{
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    System.out.println("Username or password is invalid.");
                    initialScreen();
                }                

               }while(!rs.next());
                
           } catch (SQLException e){
                System.out.println("Error in login " + e);
            }
        }

    @Override
    public void user(int userId) {
        
    }

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
                login();
            case "2":
                System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                menuSignUp.SignUpUser();
            default:
                System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                System.out.println("Sorry, wrong option... Try again.");
        }

    }    
    
}
