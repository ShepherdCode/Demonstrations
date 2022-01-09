public class Control
{
    TimeView display;
    long interval;
    TimeThread timer;
    Thread thread;
    public Control (TimeView display, long interval) {
        this.display=display;
        this.interval=interval;
    }
    public void stop () {
        if (timer != null) {
            timer.running = false;
        }
        timer=null;
        thread=null;
    }

    public void go () {
        // Stop then go
        stop();
        timer = new TimeThread(display,interval);
        timer.running = true;
        try {
            Object as_object = (Object) timer;
            thread = (Thread) as_object;
            System.out.println("Using threads!");
            thread.start();
        } catch (Exception ex) {
            thread = null;
            System.out.println("Not using threads.");
            timer.run();
        }
    }
}
