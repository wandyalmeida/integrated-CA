/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReadFile;

import java.util.ArrayList;

/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 */

public class CSVUtils {
    
/**
* Splits a line of CSV (Comma-Separated Values) into an array of values.
*
* @param line The CSV line to be split.
* @return An array of values extracted from the CSV line.
*/
    public static String[] splitCSVLine(String line) {
        ArrayList<String> values = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder currentValue = new StringBuilder();
        
        // Iterate through each character in the CSV line
        for (char c : line.toCharArray()) {
            if (c == ',' && !inQuotes) {// If the character is a comma and not inside quotes, it marks the end of a value
                values.add(currentValue.toString());
                currentValue.setLength(0);
            } else if (c == '"') {// If the character is a double quote, toggle the inQuotes flag
                inQuotes = !inQuotes;
            } else {// If the character is not a comma or double quote, append it to the current value
                currentValue.append(c);
            }
        }
        // Add the last value (or the only value if there was no comma)
        values.add(currentValue.toString());

        return values.toArray(new String[0]);// Convert the list of values to an array and return
    }
}

