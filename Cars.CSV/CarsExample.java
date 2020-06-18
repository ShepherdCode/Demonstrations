import java.util.*;
public class CarsExample {
    String fn;
    FileParserCSV fp;
    public CarsExample(String filename) {
        fn=filename;
    }

    public boolean open () {
        fp = null;
        try {
            fp=new FileParserCSV(fn);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void print () {
        System.out.println("Headers");
        Object [] cols = fp.getColumnNames();
        Object [] [] data = fp.getAllData();
        System.out.println(Arrays.deepToString(cols));
        System.out.println("Data");
        System.out.println(Arrays.deepToString(data));
    }

    public static void main () {
        CarsExample ce = new CarsExample("cars.csv");
        if (ce.open()) {
            //ce.print();
            Car [] c = ce.getCars();
            ce.printAffordableCars(c, 30000);
        }
    }

    public void printAffordableCars (Car [] cars, int price) {
        System.out.println("Recommended cars for $"+price);
        for (int i = 0; i< cars.length; i++) {
            Car c = cars[i];
            if (c.inPriceRangeOf(price)) {
                System.out.println(c);
            }
        }
    }
    
    public Car [ ] getCars() {
        Object [] [] data = fp.getAllData();
        int total = data.length;
        Car [ ] cars = new Car [total];
        for (int i=0; i<total; i++) {
            String company = (String)data[i][0];
            String model = (String)data[i][1];
            int low=(int)data[i][2];
            int high=(int)data[i][3];
            int city=(int)data[i][4];
            int hwy=(int)data[i][5];
            cars[i] = new Car (company, model);
            cars[i].setNumbers(low,high,city,hwy);
        }
        return cars;
    }
}

