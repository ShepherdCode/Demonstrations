import java.util.Deque;
public class DataStruct<T> 
implements Stack<T>, Queue<T> {
    private boolean isLIFO;
    private Deque<T> data;
    public DataStruct(Deque d)    {
        this.isLIFO = true;  
        this.data = d;
    }

    public void setToQueue() {
        this.isLIFO=false;
    }
    
    public void setToStack() {
        this.isLIFO=true;
    }
    
    public T pop () {
        return data.removeFirst();
    }
    
    public void push (T element) {
        if (this.isLIFO) {
            data.addFirst(element);
        } else {
            data.addLast(element);
        }
    }
    
    public String toString() {
        String out = "Queue:";
        if (this.isLIFO) {
            out = "Stack:";
        }
        return out+data.toString();
    }
}
