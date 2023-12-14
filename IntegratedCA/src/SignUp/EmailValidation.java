package SignUp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Charles Rocha
 */
public class EmailValidation {

    private static final String emailToBeValidated = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static Pattern pattern;
    private static Matcher matcher;
    Scanner emailScanner = new Scanner(System.in);
    String input = "", inputToLowerCase;

    public EmailValidation() {
        pattern = Pattern.compile(emailToBeValidated, Pattern.CASE_INSENSITIVE);
    }

    public boolean email_validator(String email_address) {
        matcher = pattern.matcher(email_address);
        return matcher.matches();
    }

    public String get_user_valid_input(String prompt) {

        do {
            System.out.println(prompt);
            System.out.println("Only type y or n, please: ");
            input = emailScanner.nextLine();
            inputToLowerCase = input.toLowerCase();

        } while ((!inputToLowerCase.equals("y")) && (!inputToLowerCase.equals("n")));
        return input;

    }

    public String get_user_input(String prompt) {
//        Scanner emailScanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.println(prompt + " ");
            System.out.print("Please only type letters: ");
            input = emailScanner.nextLine();
            System.out.println("");
        } while (!input.matches("[a-zA-Z ]+"));

        return input;
    }

    public int Get_user_int(String prompt, int minValue, int maxValue) {
//        Scanner emailScanner = new Scanner(System.in);
        int input = -1;
        boolean valid = false;
        do {
            System.out.print(prompt);
            try {
                input = emailScanner.nextInt();
                if (input < minValue || input > maxValue) {
                    System.out.println("The number entered does not match requirements. Please, try again:");
                } else {

                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("Error initial Screen: " + e);
                System.out.println("The value entered is not an integer. Please type only 1 or 2");
                emailScanner.next();
            }
        } while (!valid);
        System.out.println("");
        return (input);
    }
}
