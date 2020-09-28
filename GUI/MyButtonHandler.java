import java.awt.*;
import java.awt.event.*;
public class MyButtonHandler
implements ActionListener {
    Button button;
    public MyButtonHandler (Button button)    {
        this.button = button;
    }
    public void actionPerformed(ActionEvent e) { 
        System.out.println(e);
    }
}
