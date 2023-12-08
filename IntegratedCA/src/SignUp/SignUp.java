package SignUp;

import UserGetSet.User;
import java.util.Scanner;
import sql.SignUpClass;

/**
 *
 * @author Charles Rocha 2021376 Class responsible to register users in the
 * database
 */
public class SignUp implements SignUpInterface {

    Scanner userInput = new Scanner(System.in);
    SignUpClass userSignUp = new SignUpClass();

    @Override
    public void SignUpUser() {
        String email, password, name, surname; //Is it really necessary name and surname?

        //The following process will signUp an user
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("email:");
        email = userInput.next();
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

        User signUpUser = new User();
        signUpUser.setEmail(email);
        signUpUser.setPassword(password);
        signUpUser.setName(name);
        signUpUser.setSurname(surname);

        //I am not sure if it is right
        userSignUp.Sign_Up(signUpUser);
    }

}
