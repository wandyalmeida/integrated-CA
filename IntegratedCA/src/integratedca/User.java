package integratedca;

import java.util.Scanner;

/**
 *
 * @author Charles Rocha
 * This class will allow users to create and log into accounts with an email and a password.
 *  Later it will connect to DataBase
 */
public class User {
    
        Scanner mykb = new Scanner(System.in);
        
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        
    }


    

