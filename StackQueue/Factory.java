import java.util.LinkedList;
public class Factory<T> {
    public Stack<T> getStack () {
        LinkedList d = new LinkedList<T>();
        DataStruct data = new DataStruct<T>(d);
        data.setToStack();
        return data;
    }
    public Queue<T> getQueue () {
        LinkedList d = new LinkedList<T>();
        DataStruct data = new DataStruct<T>(d);
        data.setToQueue();
        return data;
    }
}
