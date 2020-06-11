public class Vehicle {
    History oilChanges;
    History gasFill;
    String name;
    private Vehicle() {
    }
    public Vehicle(String name)    {
        this.name = name;
        oilChanges = new History();
        gasFill = new History();
    }
    public void blowHorn () {
        System.out.println(name+" says: BELUGA");
    }
    public String toString () {
        return name;
    }
    public void addOil (String date) {
        this.oilChanges.add(date);
    }
    public String getLastOil () {
        return this.oilChanges.getLast();
    }
    public void addGas (String date) {
        this.gasFill.add(date);
    }
    public String getLastGas () {
        return this.gasFill.getLast();
    }
}
