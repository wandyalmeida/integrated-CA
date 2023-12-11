package integratedca;

import InitialScreen.InitialScreen;
//import Login.Login;
import ReadFile.CSVReader;
import ReadFile.Movies;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;


import sql.CreateInsertDatabase;
//import sql.Menu;
import sql.MovieMenu;

/**
 *
 * @author Charles Rocha 2021376
 * @author Wandwilson Almeida 2021230
 * @author Carolina Gomes Landim 2021226
 * @author Lucas dos Santos Barbosa 2021337
 * Only one method here
 */
public class IntegratedCA  {

    public static void main(String[] args) {
        
           
        /**
         * CompletableFuture is used to create the DataBase and insert the films
         * into the DataBase, this is done in the background to give 
         * the User time to Register or Login to the System.
         **/ 
//        CompletableFuture<Void> csvTask = CompletableFuture.runAsync(()->{
        //Starting Database
        
        CreateInsertDatabase createDB = new CreateInsertDatabase();
        createDB.create_schema();
        CSVReader csvReader = new CSVReader();
        csvReader.readData();
    
//        });
        
        InitialScreen start = new InitialScreen();
        
        start.initialScreen();
        
//        csvTask.join();
          
    }
    
}
