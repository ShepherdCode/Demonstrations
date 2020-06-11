import java.util.*;
public class RoadTest {
    ArrayList<Vehicle> cars;
    public RoadTest () {
        int startingSize=10;
        cars = new ArrayList<Vehicle>(startingSize);
    }
    public static void main () {
        RoadTest test = new RoadTest();
        test.setup();
        test.demonstrate();
    }
    public void setup() {
        Vehicle van = new Vehicle("van");
        Vehicle pickup = new Vehicle("pickup");
        EmergencyVehicle fireTruck = new EmergencyVehicle("firetruck");
        EmergencyVehicle policeCar = new EmergencyVehicle("policecar");
        cars.add(van);
        cars.add(policeCar);
        cars.add(pickup);
        cars.add(fireTruck);
        van.addOil("01Jan2020");
        fireTruck.addGas("03Jan2020");
        policeCar.addOil("17Jan2020");
        pickup.addGas("21Jan2020");
        fireTruck.addGas("20Feb2020");
    }
    public void demonstrate() {
        System.out.println("Everyone blow your horn!");
        System.out.println();
        blowHorns();
        System.out.println();
        System.out.println("Ok, when was your last maintenance?");
        System.out.println();
        checkHistory();
    }
    public void blowHorns() {
        for (Vehicle car: cars) {
            if (car instanceof EmergencyVehicle) {
                EmergencyVehicle ev = (EmergencyVehicle) car;
                ev.blastSiren();
            } else {
                car.blowHorn();
            }
        }
    }
    public void checkHistory() {
        for (Vehicle car: cars) {
            String oil = car.getLastOil();
            String gas = car.getLastGas();
            System.out.println(car+" last oil change "+oil);
            System.out.println(car+" last fill up "+gas);
        }
    }
    
}
