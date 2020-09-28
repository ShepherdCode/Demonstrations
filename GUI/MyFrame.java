import java.awt.*;
import java.awt.event.*;
public class MyFrame 
extends Frame {
    public MyFrame()    {
        setTitle("Shepherd GUI");
        MyWindowListener handler = 
            new MyWindowListener(this);
        addWindowListener(handler); 
    }


}
