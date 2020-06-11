import javax.swing.JFrame;
import java.awt.*;
/**
 * GameController runs the game.
 * It also instantiates all classes.
 * It also starts the display.
 * It also handles button events.
 */
public class GameController {
    Button nextButton;
    Button presetButton;
    GameView gameView;
    GameModel gameModel;
    JFrame frame;
    final static int GRID_SIZE = 20;
    
    public static void main () {
        GameController game = new GameController();
    }
    
    public GameController () {
        gameModel = new GameModel (GRID_SIZE,GRID_SIZE);
        gameView = new GameView(gameModel);
        frame = new JFrame("Game");
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.green);
        GridListener listener = new GridListener(this);
        gameView.addMouseListener(listener);
        frame.add(gameView);
        Panel buttons = new Panel();
        buttons.setLayout(new FlowLayout());
        nextButton = new Button ("NEXT");
        presetButton = new Button ("PRESET");
        nextButton.addActionListener(listener);
        presetButton.addActionListener(listener);
        buttons.add(nextButton);
        buttons.add(presetButton);
        frame.add(buttons);
        frame.pack();
        frame.setVisible(true);
    }
    public void handleMouseClick (Point p) {
        Point cell = gameView.findCellAtPoint(p);
        if (cell != null) {
            gameModel.toggleCell (cell.x, cell.y);
        }
        gameView.repaint();
    }
    public void handleButtonPress (Object src) {    
        if (src == nextButton) {
            gameModel.advanceOneGeneration();            
        } else if (src == presetButton) {
            gameModel.createSampleShapes();
        }
        gameView.repaint();
    }
}
