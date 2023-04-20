package OOPs.OOPs2.Vehicle;

public class Car extends Vehicle {
    int noOfDoors;
    String transmission;

    // Vehicle c = new Vehicle();
    public Car() {
        // Empty (default)
    }

    public Car(int noOfDoors, String Brand, double engineCapacity) {
        super(Brand, engineCapacity);

        System.out.println("Car class " + "No of Doors " + noOfDoors);
    }

    public void print() {
        super.print();
        System.out.println("Car color is " + this.color + " Brand " + getBrand() + " Maximum Speed " + maxSpeed);

        // super.setMaxSpeed(250);
    }

    @Override
    public boolean isMotorized() {
        // TODO Auto-generated method stub
        return true;
    }
}
