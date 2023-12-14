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

        //The following process will signUp an user
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("email:");
        email = userInput.next();
        if (!validation.emailValidator(email)) {
            System.out.println("Email not valid. \nYou should type like something@validmail.com\nTry again");
            SignUpUser();
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

            signUpUser.setEmail(email);
            signUpUser.setPassword(password);
            signUpUser.setName(name);
            signUpUser.setSurname(surname);
            userSignUp.Sign_Up(signUpUser);
        }

    }

}
