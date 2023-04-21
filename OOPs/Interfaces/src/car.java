public class car extends Vehicle implements carinterface {

    @Override
    public boolean isMotorized() {
        return true;
    }

    @Override
    public String getCompany() {
        return null;
    }

    @Override
    public int noGears() {
        return 5;
    }

    void print() {
        System.out.println(PI);
    }

}
