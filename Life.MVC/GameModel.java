/**
 * GameModel manages the game board and all its cells.
 */
public class GameModel {
    Board gameBoard;

    /**
     * Constructor.
     */
    public GameModel (int rows, int cols) {
        gameBoard = new Board (rows,cols);
    }

    /**
     * Advance one generation, starting by counting neighbors.
     * Side effect: this changes the state of many cells.
     * Algorithm: 
     * 1) Visit every cell. Update its neighbor counts.
     * 2) Visit every cell. Make it live or die.
     * @return Number of cells changed.
     */
    public int advanceOneGeneration () {
        gameBoard.updateNeighbors(); 
        return gameBoard.updateStates();
    }

    /**
     * Create some shapes to get the game started.
     * Poke each shape into the grid.
     * This works best with a grid of at least 15 x 15.
     */
    public void createSampleShapes () {
        clearAllCellStates ();
        int rows = getNumRows();
        int cols = getNumCols();
        if (rows>=3 && cols>=3) { // Stationary block
            gameBoard.toggleStateOfCell (2,2); 
            gameBoard.toggleStateOfCell (2,3);
            gameBoard.toggleStateOfCell (3,2);
            gameBoard.toggleStateOfCell (3,3);
        }
        if (rows>=9 && cols>=9) {// Here is a spinning bar.
            gameBoard.toggleStateOfCell (7,7);
            gameBoard.toggleStateOfCell (7,8);
            gameBoard.toggleStateOfCell (7,9);
        }
        if (rows>=15 && cols>=15) {// Here is an exploding box.
            gameBoard.toggleStateOfCell (14,14);
            gameBoard.toggleStateOfCell (13,14);
            gameBoard.toggleStateOfCell (15,14);
            gameBoard.toggleStateOfCell (14,13);
            gameBoard.toggleStateOfCell (14,15);
        }
        if (rows>=12 && cols >=12) {// Here is a glider.
            gameBoard.toggleStateOfCell (12,3);
            gameBoard.toggleStateOfCell (12,4);
            gameBoard.toggleStateOfCell (12,5);
            gameBoard.toggleStateOfCell (11,5);
            gameBoard.toggleStateOfCell (10,4);
        }
    }

    public void clearAllCellStates () {
        gameBoard.setAllCellStates(false);
    }

    public boolean getCurrentStateOfCell (int row, int col) {
        return gameBoard.getCurrentStateOfCell (row, col);
    }

    public int getNumRows () {
        return gameBoard.getNumRows();
    }

    public int getNumCols () {
        return gameBoard.getNumCols();
    }

    public void toggleCell (int row, int col) {
        gameBoard.toggleStateOfCell (row,col);
    }
}