import java.awt.*;
public class GUI_01 {
    public static void main() {
        Button button = new Button ();
        button.setLabel("Go Rams");

        Canvas canvas = new Canvas ();
        canvas.setSize(400,300);
        canvas.setBackground(Color.WHITE);

        MenuBar menuBar=new MenuBar();  
        Menu fileMenu=new Menu("File");  
        MenuItem saveMenu=new MenuItem("Save");  
        fileMenu.add(saveMenu);  
        menuBar.add(fileMenu);  

        Frame frame = new Frame ();
        frame.setLayout(new FlowLayout());
        frame.setMenuBar(menuBar);  
        frame.add(canvas);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}
