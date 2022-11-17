package Aircraft;

public abstract class Plane {
    private String name;
    private String sideNumber = "0";
    private int flyDistance; // км
    private double fuelConsumption; // т/год

    public Plane(String name, int flyDistance, double fuelConsumption) {
        this.name = name;
        this.flyDistance = flyDistance;
        this.fuelConsumption = fuelConsumption;
    }

    public String getName() {
        return name;
    }

    public String getSideNumber() {
        return sideNumber;
    }

    public int getFlyDistance() {
        return flyDistance;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSideNumber(String sideNumber) {
        this.sideNumber = sideNumber;
    }

    public void setFlyDistance(int flyDistance) {
        this.flyDistance = flyDistance;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
