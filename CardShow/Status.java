/**
 * Complete description of the state of the game.
 * Describes two card piles using 4 numbers.
 * There are no getters but the attributes are public.
 */
public class Status {
    public int dealerTop;
    public int dealerHeight;
    public int playerTop;
    public int playerHeight;
    
    @Override
    public String toString () {
        String s = String.format(
            "Dealer %d/%d. Player %d/%d",
            dealerTop,dealerHeight,
            playerTop,playerHeight);
        return s;
    }
}
