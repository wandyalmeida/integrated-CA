package integratedca;

import InitialScreen.InitialScreen;
//import Login.Login;
import ReadFile.CSVReader;
import sql.CreateInsertDatabase;
//import sql.Menu;


/**
 *
 * @author Charles Rocha 2021376
 * @author Wandwilson Almeida 2021230
 * @author Carolina Gomes Landim 2021226
 * @author Lucas dos Santos Barbosa 2021337 
 * Only one method here
 */
public class IntegratedCA {
    
    /**
     ** @param args the command line arguments
     *          
     *              Strategy
     * 
     * 1) Create a interfaces and class.
     * 2) Create the menu to show what the user want to do and get input.
     * 3) Start the connection with the DataBase.
     * 4) Create methods to create the Schema and the tables on the DataBase.
     * 5) Create methods to insert, select, authentication, getUserId and etc... on the DataBase.
     * 6) Create the Enum class that will be using to give the options to users.
     * 7) Start the System creating the database, start the csvreader class and show the menu to user.
     *  
     */

    public static void main(String[] args) {


        //Starting Database
        CreateInsertDatabase createDB = new CreateInsertDatabase();
        CSVReader csvReader = new CSVReader();
        InitialScreen start = new InitialScreen();

        createDB.create_schema();
        csvReader.readData();
        start.initialScreen();

    }

}
