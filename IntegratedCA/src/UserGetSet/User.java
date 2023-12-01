package UserGetSet;

/**
 *
 * @author Charles Rocha
 * This class will allow users to create and log into accounts with an email and a password.
 *  Later it will connect to DataBase
 * userId will be directly related to the moviesId
 */
public class User {
        
        private String email, password, name, surname;
        private int userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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
