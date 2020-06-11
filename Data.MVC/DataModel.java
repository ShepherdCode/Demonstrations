import java.util.*;
/**
 * The Data Model manages one table of data.
 */
public class DataModel {
    Object [][] dataArray;
    Object [] columnNames;
    int rows, cols;
    String filename;
    /**
     * Construct a Data Model.
     */
    public DataModel () {
        this.rows=0;
        this.cols=0;
        dataArray = new Object[0][0];
        columnNames = new Object[0];
    }

    /**
     * Get the data table.
     * The return is a 2D matrix consiting of rows of fields.
     * Every row assumed to have the same number and types of fields.
     * Column count assumed the same as that of the column names.
     * Every cell assumed to be type String, Integer, or Double.
     * The returned table excludes column headers.
     * @return A table of values. Possibly empty.
     */
    public Object [] [] getAllData () {
        return dataArray;
    }

    /**
     * Get the column names.
     * Every name is of type String, Integer, or Double.
     * @return An array of column names. Possibly empty.
     */
    public Object [] getColumnNames () {
        return columnNames;
    }

    /**
     * Sort the table.
     * Sorts the rows using Arrays.sort().
     * Sorts based on one column only.
     * @param column The column number to sort on. Starts at zero.
     */
    public void sort (int column) {
        RowCompare rc = new RowCompare(column);
        Arrays.sort(dataArray,rc);
    }

    /**
     * Load an entire CSV file into RAM.
     * Use getter methods on this class to access the loaded data.
     * This would print errors on the console if the file is not found.
     * @return Whether the file could be loaded.
     */
    public boolean loadFromCSV (String filename) {
        this.filename = filename;
        FileParserCSV parser;
        try {
            parser = new FileParserCSV (filename);
        } catch (Exception e) {
            System.out.println("Cannot parse "+filename);
            System.out.println("Technical error description follows.");
            System.out.println(e);
            return false;
        }
        dataArray = parser.getAllData();
        columnNames = parser.getColumnNames();
        cols = 0;
        rows = dataArray.length;
        if (rows>0) {
            cols = dataArray[0].length;
        }
        return true;
    }
    /**
     * Report the number of rows of data currently in memory.
     */
    public int getNumRows () {
        return rows;
    }
    /**
     * Report the number of columns in the table this is currently in memory.
     */
    public int getNumCols () {
        return cols;
    }

}