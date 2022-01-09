public class Immutable {
    private int x;
    public Immutable(int setting)    {
        x = setting;
    }
    public Immutable sampleMethod(int y)    {
        return new Immutable (x+y);
    }
}
