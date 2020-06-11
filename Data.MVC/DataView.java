import javax.swing.*;
/**
 * This Component displays the contents of a DataModel using a JTable.
 */
public class DataView extends JScrollPane {
    JTable table;
    DataModel dm;
    /**
     * Construct this Component.
     * @param dm An instance of DataModel. Can be empty. Cannot be null.
     */
    public DataView(DataModel dm)    {
        this.table = new JTable();
        this.dm = dm;
        setDataModel (dm);
    }
    /**
     * Establish a new Data Model and update the view.
     * @param dm An instance of DataModel. Can be empty. Cannot be null.
     */
    public void setDataModel (DataModel dm) {
        if (dm != null) {
            table = new JTable ( dm.getAllData(), dm.getColumnNames() );
        }
        setViewportView (table);
    }
}
