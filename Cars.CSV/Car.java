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
        String display = String.format("{%s %s: price $%d-%d, city %d mpg, hwy %d mpg.}",
         company,model,low,high,city,hwy);
         return display;
    }
    
    public boolean inPriceRangeOf (int price) {
        return (low<=price && price<=high);
    }
    
    public static void carDemo() {
        Car car = new Car ("Toyota", "Camry");
        car.setNumbers(20000, 30000, 30, 35);
        System.out.println("Use this class to organize car data.");
        System.out.println("Here is an example of Car.toString():");
        System.out.println(car);
    }
}
