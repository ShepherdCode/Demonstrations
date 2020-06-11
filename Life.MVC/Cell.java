
/**
 * One cell of the board of the Game of Life.
 * The cell does not communicate with other cells.
 * This cellular automata computes whether to live or die
 * given the crowding conditions.
 * A special kind of cell, "border", never updates itself.
 */
public class Cell {
    boolean state;
    int neighbors;
    boolean border;
    static final int MINIMUM=2;
    static final int MAXIMUM=3;
    static final int IDEAL=3;

    public Cell()   {
        state = false;
        neighbors = 0;
        border = false;
    }

    public void makeBorder() {
        border = true;
    }

    public void setState (boolean newState) {
        if (!border) {
            state = newState;
        }
    }

    public boolean getState () {
        if (border) {
            return false;
        }
        return state;
    }

    public void setCount (int value) {
        if (!border) {
            neighbors = value;
        }
    }

    public int getCount () {
        if (border) {
            return 0;
        }
        return neighbors;
    }

    /**
     * Determine whether the cell should live. 
     * @return This cell's proper state for next generation.
     */
    boolean predictNextState () {
        boolean nextState = state;
        if (state) {
            if (neighbors<MINIMUM || neighbors>MAXIMUM) {
                nextState=false;
            }
        } else {
            if (neighbors==IDEAL) {
                nextState=true;
            }
        }
        return nextState;
    }

}
