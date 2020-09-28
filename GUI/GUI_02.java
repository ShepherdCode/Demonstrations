import java.awt.*;
public class GUI_02 {
    public static void main() {
        MyButton button = new MyButton ();

        MyCanvas canvas = new MyCanvas ();

        MenuBar menuBar=new MenuBar();  
        Menu fileMenu=new Menu("File");  
        MenuItem saveMenu=new MenuItem("Save");  
        fileMenu.add(saveMenu);  
        menuBar.add(fileMenu);  

        Frame frame = new MyFrame ();
        frame.setLayout(new FlowLayout());
        frame.setMenuBar(menuBar);  
        frame.add(canvas);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}
