
/**
 * This class manages a 2D array of Cell.
 * This class handles the mechanics of traversing the 2D array.
 * Each cell has a neighbor count and a state.
 * Setting either one does not change the other automatically.
 * Instead, updating all neighbor counts is one operation,
 * and updating all states is another operation.
 */
public class Board {
    Cell [][] allCells;
    int rows, cols;

    /**
     * Constructor.
     * Create internal 2D array of cells.
     * The array includes a 1-cell border whose cells never change.
     */
    public Board (int rows, int cols)   {
        this.rows = rows;
        this.cols = cols;
        allCells = new Cell [rows] [cols];
        Cell cell;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cell = new Cell();
                allCells[r][c]=cell;
                if (r==0 || c==0 || r==rows-1 || c==cols-1) {
                    cell.makeBorder();
                }
            }
        }
    }

    public int getNumRows () {
        return rows;
    }

    public int getNumCols () {
        return cols;
    }

    public boolean isValid (int row, int col) {
        return (row>=0 && col>=0 && row<rows && col<cols);
    }

    public Cell getCell (int row, int col) {
        if (isValid (row,col)) {
            return allCells[row][col];
        }
        return null;
    }

    public void setAllCellStates (boolean newState) {
        Cell cell;
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                cell = getCell(row,col);
                cell.setState(newState);
            }
        }
    }

    public boolean getCurrentStateOfCell (int row, int col) {
        Cell cell;
        boolean state = false;
        if (isValid(row,col)) {
            cell = allCells [row] [col];
            state = cell.getState();
        }
        return state;
    }

    public void toggleStateOfCell (int row, int col) {
        Cell cell;
        if (isValid(row,col)) {
            cell = getCell(row,col);
            cell.setState ( ! cell.getState () );
        }
    }

    public void setAllCellNeighborCounts (int value) {
        Cell cell;
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                cell = getCell(row,col);
                cell.setCount(value);
            }
        }
    }

    public int getNeighborCountOfCell (int row, int col) {
        Cell cell;
        int value = 0;
        if (isValid(row,col)) {
            cell = getCell(row,col);
            value = cell.getCount();
        }
        return value;
    }

    /**
     * If this cell is ON, increment counts in 8 neighbor cells.
     */
    public void incrementNeighborsOf (int r, int c) {
        Cell centroid, neighbor;
        int row,col,newCount;
        if (isValid(r,c)) {
            centroid = getCell(r,c);
            if (centroid.getState()) {
                for (row = r-1; row <= r+1; row++) {
                    for (col = c-1; col <= c+1; col++) { 
                        if ( ! (row==r && col==c)) {
                            neighbor = getCell(row,col);
                            newCount = 1+neighbor.getCount();
                            neighbor.setCount(newCount);
                        }
                    }
                }
            }
        }
    }

    /**
     * Visit every cell and make it live or die.
     * @return Number of cells that change state.
     */
    public int updateStates () {
        int row,col;
        Cell cell;
        int changes = 0;
        boolean oldState,newState;
        for (row=0; row<getNumRows(); row++) {
            for (col=0; col<getNumCols(); col++) {
                cell = getCell(row,col);
                oldState=cell.getState();
                newState=cell.predictNextState();
                if (newState != oldState) {
                    cell.setState(newState);
                    changes++;
                }
            }
        }
        return changes;
    }

    /**
     * Visit every cell and update its neighbor count.
     */
    public void updateNeighbors () {
        setAllCellNeighborCounts(0);
        int row,col;
        Cell cell;
        for (row=0; row<rows; row++) {
            for (col=0; col<cols; col++) {
                cell = getCell(row,col);
                incrementNeighborsOf (row,col);
            }
        }
    }

}
