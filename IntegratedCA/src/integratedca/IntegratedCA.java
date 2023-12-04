package integratedca;

import Login.Login;
import ReadFile.CSVReader;
import ReadFile.Movies;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Charles Rocha
 * Only one method here
 */
public class IntegratedCA  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Login start = new Login();
        
        start.menu();
        
        //This is to test 
//        try {
//             CSVReader csvReader = new CSVReader();
//             ArrayList<Movies> movies = csvReader.readData();
//
//             for (Movies movie : movies) {
//                 System.out.println(movie);
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
          
    }
    
}
