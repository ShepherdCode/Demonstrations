import java.lang.Thread;
public class TimeThread {
    public boolean running;
    TimeView display;
    long interval;
    public TimeThread (TimeView display, long interval) {
        this.display = display;
        this.running = false;
        this.interval = interval; // ms
    }
        
    /**
     * Forever, update the time display.
     * This never returns.
     */
    public void run () {
        long elapsedTime = 0;
        try {
            while (true) { // This is an infinite loop!!!
                Thread.sleep(this.interval);
                if (running) {
                    elapsedTime = display.getCurrent() + this.interval;
                    display.setCurrent(elapsedTime);
                    System.out.println(elapsedTime+" ms elapsed");
                }
            }
        } catch (Exception e) {
            System.err.println("Quitting now.");
        }
    }
}
