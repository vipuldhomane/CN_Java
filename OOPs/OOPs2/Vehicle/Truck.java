package OOPs.OOPs2.Vehicle;

public class Truck extends Vehicle {
    public Truck(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    @Override
    public boolean isMotorized() {
        // TODO Auto-generated method stub
        return true;
    }
}
