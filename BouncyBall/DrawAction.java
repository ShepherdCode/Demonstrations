public class DrawAction extends Thread {
    DrawCanvas canvas;
    
    public DrawAction (DrawCanvas canvas) {
        this.canvas = canvas;
    }
    
    public void run() {
        while (true) {
            canvas.pushBall(10);  // pixels
            canvas.repaint();    
            try {
                Thread.sleep(200);  // milliseconds
            } catch (InterruptedException ex) {
                System.out.println("Wake up!");
            }
        }
    }
}
