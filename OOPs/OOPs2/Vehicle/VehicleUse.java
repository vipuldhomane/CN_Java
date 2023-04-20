package OOPs.OOPs2.Vehicle;

public class VehicleUse {
    public static void main(String[] args) {

        // Vehicle v = new Vehicle("Audi", 2.0);
        // Vehicle v;
        // v.color = "Red";
        // v.maxSpeed = 250;
        // v.print();
        // System.out.println(v.getMaxSpeed());
        Car c = new Car();
        c.setBrand("Mercedes");
        c.color = "Black";
        c.maxSpeed = 250;
        c.print();
        System.out.println(c.isMotorized());

        // Truck tata = new Truck(32);
        // tata.setMaxSpeed(120);
        // int max = tata.getMaxSpeed();
        // System.out.println(max);
        // // tata.print();
    }

}