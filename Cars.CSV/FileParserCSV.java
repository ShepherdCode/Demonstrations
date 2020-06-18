import java.io.*;
import java.util.*;
/**
 * Parse a CSV file.
 * Splits lines on the COMMA delimiter between data cells.
 * Retains any COMMA between a pair of QUOTE marks.
 * Removes the initial and final QUOTE mark if present within a data cell. 
 * Retains embedded QUOTE marks i.e. QUOTE text QUOTE QUOTE text QUOTE.
 * Correctly handles: "DeCart said ""I think, therefore I am"" in his book."
 * Preserves empty strings (e.g. ",,," is converted to four data cells).
 * Assumes the first row contains headers. Provides headers separate from data.
 * Converts cells to Integer or Double if possible.
 * Provides all other cell types as String.
 * No support for Microsoft extensions for CSV eported from Excel.
 * @author Jason Miller
 */   
public class FileParserCSV {
    final char QUOTE='"';
    final char COMMA=',';
    String filename;
    Object [] [] results;
    Object [] headers;
    /**
     * Get the data matrix.
     * Each cell name may be type String, Integer, or Double.
     * @return A table consisting of rows of cells. May be empty.
     */
    public Object [] [] getAllData () {
        return results;
    }

    /**
     * Get the column names.
     * Each column name may be type String, Integer, or Double.
     * @return An array of objects.
     */
    public Object [] getColumnNames () {
        return headers;
    }

    /**
     * Construct the parser. 
     * This parses the given file immediately. 
     * This loads all the data to RAM (not appropriate for very large files).
     * This can handle any number of rows and columns.
     * The parser may print warnings on the console.
     * @param filename The file to be parsed. Assumed of type CSV.
     */
    public FileParserCSV(String filename)    
    throws FileNotFoundException, IOException { 
        this.filename = filename;
        Object [] fields;
        int fieldNum = 0;
        int i=0;
        ArrayList<Object[]> lines = new ArrayList<Object[]>(); 
        BufferedReader reader = new BufferedReader(new FileReader(filename)); 
        String line; 
        int numFields=0, numLines=0;
        Object keyy ="Agree";
        while ((line = reader.readLine()) != null)  { 
            if (numLines==0) {
                this.headers = parseLineCSV(line);
            } else {
                fields = parseLineCSV(line);
                lines.add(fields);
            } 
            numLines++;
        }
        reader.close();
        if (!lines.isEmpty()) {
            numFields = lines.get(0).length;
        }
        results = new Object[lines.size()][numFields];
        results = lines.toArray(results);
        if (headers.length==0) {
            System.out.println("WARNING: no headers and no data.");
        } else if (results.length==0) {
            System.out.println("WARNING: headers but no data.");
        } else if (headers.length != results[0].length) {
            System.out.println("WARNING: inconsistent number of columns.");
        }
    }

    /**
     * Extract one field from one line of a CSV file.
     * @param line One entire line of the file.
     * @param start The first character to extract. Starts with zero.
     * @param end The first character to ignore i.e. last + 1.
     * @return A String or Integer or Double.
     */
    Object extractField (String line, int start, int end) {
        String word = "";
        char cc;
        while (start >= 0 && start < line.length() 
        && line.charAt(start)==QUOTE) {
            start++;
        }
        while (end > 0 && end <= line.length() 
        && line.charAt(end-1)==QUOTE) {
            end--;
        }
        if (end > start) {
            word = line.substring(start,end);
        }
        return convertField (word);
    }

    /**
     * Convert a String to Integer or Double if possible.
     * @param word A String to be tested.
     * @return An Object whose type is String, Integer, or Double.
     */
    Object convertField (String word) {
        Object returnValue = word;

        try {
            int converted = Integer.valueOf(word);
            returnValue = new Integer (converted);
        } catch (Exception e) {
            // not a valid int
            try {
                double converted = Double.valueOf(word);
                returnValue = new Double (converted);
            } catch (Exception f) {
                // not a valid double
            }
        }
        return returnValue;
    }

    /**
     * Parse one line of a CSV file.
     * Returned array holds objects of type String, Integer, and Double.
     * @param line One line of a CSV file.
     * @return An array of objects representing fields in the line.
     */
    Object[] parseLineCSV(String line) {
        ArrayList<Object> fields = new ArrayList<Object>();
        int pos;
        char cc;
        String ct;
        boolean quoted = false;
        int wordStart = 0;
        if ( ! line.isEmpty() ){
            for (pos=0; pos<line.length(); pos++) {
                cc = line.charAt(pos);
                if (cc == QUOTE) {
                    quoted = !quoted;
                } else if (!quoted && cc == COMMA && pos>=0) {
                    fields.add(extractField(line,wordStart,pos));
                    wordStart = pos+1;
                }
            }
            fields.add(extractField(line,wordStart,pos));
        }
        Object[] ary = new Object [fields.size()];
        ary = fields.toArray(ary);
        return ary;
    }

    public static void main () {
        try {
            String fn = "test.csv";
            FileWriter fw = new FileWriter (fn);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("NumberType,Num1,Num2,Num3\n");
            bw.write("Integers,1,2,3\n");
            bw.write("Doubles,10.1,20.2,30.3\n");
            bw.close();
            FileParserCSV fp = new FileParserCSV(fn);
            System.out.println("Headers");
            System.out.println(Arrays.deepToString(fp.getColumnNames()));
            System.out.println("Data");
            System.out.println(Arrays.deepToString(fp.getAllData()));
        } catch (Exception e) {
            System.out.println("Sorry but there was a problem.");
            System.out.println("Here is the exception that was caught.");
            System.out.println(e);
        }
    }
}
