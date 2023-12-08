package integratedca;

import InitialScreen.InitialScreen;
//import Login.Login;
import ReadFile.CSVReader;
import ReadFile.Movies;
import java.util.ArrayList;
import java.util.Arrays;
import sql.CreateInsertDatabase;

/**
 *
 * @author Charles Rocha 2021376
 * Only one method here
 */
public class IntegratedCA  {

    public static void main(String[] args) {
        
           
         //Starting Database
        CreateInsertDatabase createDB = new CreateInsertDatabase();
        createDB.create_schema();
        
        InitialScreen start = new InitialScreen();
        
        start.initialScreen();
        
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
