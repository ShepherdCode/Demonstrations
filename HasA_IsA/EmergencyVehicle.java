public class EmergencyVehicle extends Vehicle {
    public EmergencyVehicle(String name) {
        super(name);
    }
    public void blastSiren () {
        System.out.println(name+" says: EEE OOO EEE OOO!");
    }
}
