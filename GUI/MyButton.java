import java.awt.*;
import java.awt.event.*;
public class MyButton 
extends Button {
    public MyButton()    {
        setLabel("Go Rams");
        MyButtonHandler handler = new MyButtonHandler(this);
        addActionListener(handler);
    }
}
