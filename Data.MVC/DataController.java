import javax.swing.JFrame;
import java.awt.*;
/**
 * The Controller for the Data File Viewer.
 * Use this class to start the program.
 * This program loads and displays a table of data.
 */
public class DataController {
    Button loadButton;
    Button sortButton;
    DataView dataView;
    DataModel dataModel;
    JFrame frame;
    String filename;
    /** 
     * Launch the program with a hard-coded CSV filename.
     */
    public static void main () {
        String fn;
        fn = "Heart.csv";  // swap lines to try the other file
        fn = "College.csv";
        DataController gc = new DataController(fn);
    }
    /**
     * Constructor.
     * This starts the program.
     * The file is assumed of type CSV.
     * The filename may include a path+name or just the file name.
     * Creates a data model, a data view, an event listener, and wires them together.
     * @param The name of the file to display.
     */
    public DataController (String filename) {
        this.filename = filename;
        dataModel = new DataModel ();
        dataView = new DataView(dataModel);
        Dimension tableSize = new Dimension(600,400);
        dataView.setPreferredSize(tableSize);
        frame = new JFrame(filename);
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.green);
        EventsListener listener = new EventsListener(this);
        dataView.addMouseListener(listener);
        frame.add(dataView);
        Panel buttons = new Panel();
        buttons.setLayout(new FlowLayout());
        loadButton = new Button ("LOAD");
        sortButton = new Button ("SORT");
        loadButton.addActionListener(listener);
        sortButton.addActionListener(listener);
        buttons.add(loadButton);
        buttons.add(sortButton);
        frame.add(buttons);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Handle a mouse click on the Data View.
     * This is currently a no-op.
     * @param p A point with x and y coords relative to the Data View.
     */
    public void handleMouseClick (Point p) {
    }
    /**
     * Handle a mouse click on a Button.
     * The specific response depends on which button was clicked.
     * This instructs the Data Model to change in some way.
     * Then, this instructs the Data View to update the display.
     * @param src The button that was clicked.
     */
    public void handleButtonPress (Object src) {    
        if (src == loadButton) {
            System.out.printf("Loading file %s ...\n",filename);
            dataModel.loadFromCSV(filename); 
            System.out.printf("Loaded %d rows and %d columns.\n",
                dataModel.getNumRows(), dataModel.getNumCols());
            dataView.setDataModel(dataModel); // may not be necessary
        } else if (src == sortButton) {
            int COLUMN_TO_SORT_BY = 2;
            System.out.printf("Sorting by column %d.\n",COLUMN_TO_SORT_BY);
            dataModel.sort(COLUMN_TO_SORT_BY);
            dataView.setDataModel(dataModel); // may not be necessary
        }
        dataView.repaint();
    }
}
