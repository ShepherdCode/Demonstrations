import javax.swing.*;
public class TimeView extends JLabel {
    Long millisec;
    public TimeView() {
        millisec = new Long(0);
        resetText();
    }

    public void resetText() {
        setText (millisec.toString());
    }

    public void setCurrent (long ms) {
        this.millisec = new Long (ms);
        resetText();
    }

    public long getCurrent () {
        return millisec.longValue();
    }
}