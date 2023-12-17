package SignUp;

import UserGetSet.User;
import java.util.Scanner;
import sql.SignUpClass;

/**
 *
 * @author Charles Rocha 2021376 Class responsible for register users in the
 * database
 */
public class SignUp implements SignUpInterface {

    Scanner userInput = new Scanner(System.in);
    SignUpClass userSignUp = new SignUpClass();
    EmailValidation validation = new EmailValidation();
    User signUpUser = new User();

    @Override
    public void SignUpUser() {
        String email, password, name, surname;

        //The following process will see if the user is inserting a valid email
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("email:");
        email = userInput.next();
        if (!validation.emailValidator(email)) {
            System.out.println("Email not valid. \nYou should type like something@validmail.com\nTry again");
            SignUpUser();
            //Now the user will insert each of the following informations
        } else {
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            System.out.println("password:");
            password = userInput.next();
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            System.out.println("name:");
            name = userInput.next();
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            System.out.println("surname:");
            surname = userInput.next();
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

            //And then all the information will be set in their proper place
            signUpUser.setEmail(email);
            signUpUser.setPassword(password);
            signUpUser.setName(name);
            signUpUser.setSurname(surname);
            userSignUp.Sign_Up(signUpUser);
        }

    }

}
