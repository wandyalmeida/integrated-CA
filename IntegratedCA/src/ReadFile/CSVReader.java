/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import sql.CheckMovies;
import sql.InsertMovie;

/**
 *
 * @author Wandwilson Almeida 2021230
 */
public class CSVReader extends FileIO implements CSVReaderInterface {
    private int numColumns;
    private String[] header;
    private Map<String, Integer> columnIndexMap = new HashMap<>();
    private CheckMovies checkMovies = new CheckMovies();
    private InsertMovie insertMovie = new InsertMovie();
    private Movies movie = new Movies();
    
    @Override
    public ArrayList<Movies> readData() {
     ArrayList<Movies> movies = new ArrayList<>();

     try (Scanner readFile = new Scanner(new File(fileName + ".csv"))) {
         // Read the header line
         if (readFile.hasNextLine()) {
             String headerLine = readFile.nextLine();
             header = CSVUtils.splitCSVLine(headerLine);
             numColumns = header.length;

             // Map column names to indices
             columnIndexMap = new HashMap<>();
             for (int i = 0; i < numColumns; i++) {
                 columnIndexMap.put(header[i], i);
             }
         }
         // Process the lines and create Movie objects
         while (readFile.hasNextLine()) {
             movie = new Movies(); // Create a new Movies object for each line
             String line = readFile.nextLine();


             if (line.trim().isEmpty() || line.trim().equals(",,,,,,,,,,")) {
                 break; // Exit the loop if the line is empty (end of file)
             }

             String[] values = CSVUtils.splitCSVLine(line);

             movie.setTitle(values[columnIndexMap.get("original_title")].trim()); // Column B (index 1)

             // Handle the value of column K as price only if it's a number
             String priceValue = values[columnIndexMap.get("price")].trim();

             double price = Double.parseDouble(priceValue);
             movie.setPrice(price); // Column K (index 10)
             movies.add(movie);
         }

         // Check if the movies already exist in the database
         if (!checkMovies.CheckMovies(movies)) {
             // Insert into the database
             insertMovie.InsertMovie(movies);
         }

     } catch (FileNotFoundException e) {
         System.out.println("The file: " + fileName + ".csv could not be located.");

     }

     return movies;
 }
    
    @Override
    public int getNumColumns() {
        return numColumns;
    }

    @Override
    public String[] getHeader() {
        return header;
    }
}