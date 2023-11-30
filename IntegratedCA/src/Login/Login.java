package Login;

import java.util.Scanner;

/**
 *
 * @author Charles Rocha
 */
public class Login implements LoginInterface {
    
    Scanner mykb = new Scanner (System.in);

    @Override
    public void login() {
        
    }

    @Override
    public void user(int userId) {
        
    }

    @Override
    public void menu() {
        System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");
        System.out.println("Welcome to  ÉirVid!\nIt is a pleasure to have you here!");
        System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");
        
        System.out.println("Select your option:");
        System.out.println("1 - Login\n2 - SignUp");
    }
    
    
    
    
}
