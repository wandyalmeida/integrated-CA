/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enum;


/**
 *
 * @author Lucas dos Santos Barbosa - 2021337
 */

//enum creation for the menu
public class MovieMenu {
 
    public enum MenuOption {
    SEE_MOVIES("Rent our movies"),
    SEE_RENTS("See your movies rented"),
    LOG_OUT("log out");
    

    private final String option;
    
    //the constructor 
    MenuOption(String option) {
        this.option = option;
    }
    
    //This method returns the string represetation of the of the option
    public String getOption() {
        return option;
    }
}

    
} 
    

