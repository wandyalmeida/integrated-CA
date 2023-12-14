package SignUp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Charles Rocha
 */
public class EmailValidation {
    
    /**
     * The following regular expression validates an email address with the following criteria:
     * The local part (before '@') allows letters, numbers, and some special characters;
     * It can have optional sub-domains separated by dots in the local part;
     * The '@' character is required;
     * The domain part (after '@') allows letters, numbers, and hyphens, with at least one dot separating sub-domains;
     * The country code part has between 2 and 7 alphabetical characters. 
     */
    
    private static final String emailToBeValidated = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static Pattern pattern;
    private static Matcher matcher;

    /*
     * The constructor initializes a Pattern object with a regular expression for email validation, 
     * and the Pattern.CASE_INSENSITIVE flag is set to make the pattern matching case-insensitive
     */
        public EmailValidation() {
        pattern = Pattern.compile(emailToBeValidated, Pattern.CASE_INSENSITIVE);
    }

        /*
        * This method takes an email address as input, creates a Matcher object using the compiled pattern, 
        * and then checks if the entire email address matches the pattern. 
        */
        public boolean emailValidator(String email_address) {
        matcher = pattern.matcher(email_address);
        return matcher.matches();
    }

}
