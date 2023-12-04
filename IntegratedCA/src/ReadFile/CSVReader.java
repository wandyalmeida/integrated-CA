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

/**
 *
 * @author Wandwilson Almeida 2021230
 */
public class CSVReader extends FileIO implements CSVReaderInterface {
    private int numColumns;
    private String[] header;
    ArrayList<Movies> movies = new ArrayList<>();
    Map<String, Integer> columnIndexMap;
    
    @Override
    public ArrayList<Movies> readData() {
        try {
            Scanner readFile = new Scanner(new File(fileName + ".csv"));
            
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
                String[] values = CSVUtils.splitCSVLine(readFile.nextLine());

                Movies movie = new Movies();
                movie.setTitle(values[columnIndexMap.get("original_title")].trim());  // Column B (index 1)

                // Handle the value of column K as price only if it's a number
                String priceValue = values[columnIndexMap.get("price")].trim();
                try {
                    double price = Double.parseDouble(priceValue);
                    movie.setPrice(price);  // Column K (index 10)
                    movies.add(movie);
                } catch (NumberFormatException e) { //Show this error if one of the movie do not have a price
                    System.out.println("Value of the price column: " + priceValue);
                }
            }

            readFile.close();
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