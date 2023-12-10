/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;


/**
 *
 * @author Lucas dos Santos Barbosa
 */
public class MovieMenu {
 
    public enum MenuOption {
    SEE_MOVIES("Check our movies"),
    EXIT("log out");

    private final String option;

    MenuOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}

    
} 
    

