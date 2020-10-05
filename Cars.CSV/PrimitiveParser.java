import java.io.*;
import java.util.*;
/**
 * Parse a CSV file using the String.split(",") method.
 * This is primitive and it won't work on all CSV files.
 */
public class PrimitiveParser {
    public final String DELIMITER = ",";
    boolean success;
    
    public PrimitiveParser()    {
        success = true;
    }

    /**
     * Indicates whether the last file operation was successful.
     */
    public boolean wasSuccess() {
        return success;
    }

    /**
     * Show file contents on the Java console.
     */
    public void parseAndPrint(String filename) {
        try {
            FileReader fr = new FileReader(filename); 
            BufferedReader br = new BufferedReader(fr);
            String line; 
            while ((line = br.readLine()) != null)  { 
                String[] data = line.split(DELIMITER);
                System.out.println(Arrays.toString(data));
            }
            success = true;
        }
        catch (Exception e) {
            System.err.println("Could not read file "+filename);
            success = false;
        }
    }

    /**
     * Parse a CSV file.
     * Load a data structure.
     * Return the data structure.
     */
    public ArrayList<String[]> parse(String filename) {
        String line; 
        String[] row;
        ArrayList<String[]> rows = new ArrayList<String[]>(10);
        try {
            FileReader fr = new FileReader(filename); 
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null)  { 
                row = line.split(DELIMITER);
                rows.add(row);
            }
            success = true;
        }
        catch (Exception e) {
            System.err.println("Could not read file "+filename);
            success = false;
        }
        return rows;
    }

    /**
     * Given a data structure, dump contents to the console.
     */
    public void print (ArrayList<String[]> data) {
        String[] row;
        Iterator<String[]> iter = data.iterator();
        while (iter.hasNext()) {
            row = iter.next();
            System.out.println(Arrays.toString(row));
        }   
    }

    public static void main () {
        String FILENAME = "Cars.csv";
        PrimitiveParser sp = new PrimitiveParser();
        
        System.out.println("Just print...");
        sp.parseAndPrint(FILENAME);
        
        System.out.println("\nLoad the data, then print...");
        ArrayList<String[]> data = sp.parse(FILENAME);
        sp.print(data);
    }
}
