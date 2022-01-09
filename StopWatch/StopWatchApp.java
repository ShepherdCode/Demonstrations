import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.Thread;
public class StopWatchApp  {
    TimeView disp;
    Button startButton, stopButton;
    JPanel main;
    Listener listener;
    JFrame frame;
    TimeThread timer;
    Control control;
    public static void main () {
        StopWatchApp swa = new StopWatchApp();
    }

    public StopWatchApp() {
        frame = new JFrame();
        JPanel main = new JPanel();
        LayoutManager man = new BoxLayout(main,BoxLayout.Y_AXIS);
        int BS = 10;
        Border border = BorderFactory.createEmptyBorder(BS, BS, BS, BS);
        float alignment = Component.CENTER_ALIGNMENT;
        startButton = new Button ("START");
        stopButton = new Button ("STOP");
        //
        disp = new TimeView ();
        control = new Control(disp, 50);
        listener = new Listener(control);
        listener.setStarter(startButton);
        listener.setStopper(stopButton);
        startButton.addActionListener(listener);
        stopButton.addActionListener(listener);
        //
        main.setLayout (man);
        main.setAlignmentX (alignment);
        main.setBorder (border);
        main.add (new JLabel ("MilliSeconds"));
        main.add (disp);
        main.add (startButton);
        main.add (stopButton);        
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }
}