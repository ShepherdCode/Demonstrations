public class Car {
    private String company, model;
    private int low,high,city,hwy;
    public Car(String company, String model) {
        this.company=company;
        this.model=model;
    }

    public void setNumbers (int low, int high, int city, int hwy) {
        this.low=low;
        this.high=high;
        this.city=city;
        this.hwy=hwy;
    }

    public String toString() {
        return "{"+company+","+model+
        " $"+low+" to $"+high+
        ", "+city+" to "+hwy+" mpg}";
    }
    
    public boolean inPriceRangeOf (int price) {
        return (low<=price && price<=high);
    }
}
