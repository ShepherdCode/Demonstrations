package Binary;

// TO DO: write JavaDoc for this class.
public class ShepNumber {
    int instanceVariable;
    ShepNumber() {
        // TO DO: assign the instance variable the value 0.
    }
    ShepNumber (int n) {
        // TO DO: assign the instance variable the value n.
    }
    public int getInt () {
        // TO DO: return the value of the instance variable.
        return 0;
    }
    public String getDecimalString () {
        // TO DO: convert instance variable to String.
        // One possibility is the static method Integer.toString(n).
        // Another possibility is the constructor String(n).
        return "";
    }
    public String getBinaryString() {
       return this.toBinaryString(instanceVariable);
    }
    private String toBinaryString(int n) {
        // TO DO: implement an algorithm.
        // For this exercise, don't use Integer.toBinaryString().
        // Instead, implement the divide-by-two algorithm.
        // It is possible to use recursion or iteration.
        // For this exercise, please use recursion.
        return "";
    }
}
