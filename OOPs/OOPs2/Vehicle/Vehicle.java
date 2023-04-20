package OOPs.OOPs2.Vehicle;

public abstract class Vehicle {
    private String Brand;
    private double engineCapacity;
    String color;
    int noOfWheels;
    int maxSpeed = 250;

    public Vehicle() {
        // Empty constructor
    }

    public Vehicle(String Brand, double engineCapacity) {
        // System.out.println("Vehicle Const");
        this.Brand = Brand;
        this.engineCapacity = engineCapacity;
        // System.out.println("Brand " + this.Brand + " EngineCapacity " +
        // this.engineCapacity);
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCapacity() {
        return this.engineCapacity;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getBrand() {
        return this.Brand;
    }

    public void print() {
        System.out.println("Vehicle color is " + color + " " + Brand + " " +
                maxSpeed);
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(int MaxSpeed) {
        this.maxSpeed = MaxSpeed;
    }

    public abstract boolean isMotorized();

}
