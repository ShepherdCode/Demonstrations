public class MyInteger implements Comparable<MyInteger> {
    int value;
    public MyInteger (int value) {
        this.value=value;
    }
    
    public String toString () {
        return ""+value;
    }
    
    public int compareTo (MyInteger that) {
        //System.out.printf("Compare this %d to that %d\n",
        //this.value, that.value);
        return this.getInt() - that.getInt();
    }
    
    public int getInt() {
        return value;
    }
}
