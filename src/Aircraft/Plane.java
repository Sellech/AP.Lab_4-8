package Aircraft;

public class Plane {
    private String name;
    private String sideNumber = "0";
    private int flyDistance; // км
    private double fuelConsumption; // т/год
    private int passengerCapacity;
    private double cargoCapacity;  // т

    /**
     * Конструктори
     */
    public Plane(String name, int flyDistance, double fuelConsumption,
                 int passengerCapacity, double cargoCapacity) {
        this.name = name;
        this.flyDistance = flyDistance;
        this.fuelConsumption = fuelConsumption;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
    }

    public Plane(String name, String sideNumber, int flyDistance, double fuelConsumption,
                 int passengerCapacity, double cargoCapacity) {
        this.name = name;
        this.sideNumber = sideNumber;
        this.flyDistance = flyDistance;
        this.fuelConsumption = fuelConsumption;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Конструктор копіювання
     */
    public Plane(Plane plane){
        this.name = plane.name;
        this.flyDistance = plane.flyDistance;
        this.fuelConsumption = plane.fuelConsumption;
        this.passengerCapacity = plane.passengerCapacity;
        this.cargoCapacity = plane.cargoCapacity;
    }

    @Override
    public String toString() {
        return ("\t"+name
                +"\nБортовий номер: "+ sideNumber
                +"\nМакс. дальність: "+ flyDistance + " (км)"
                +"\nВитрата палива: "+ fuelConsumption + "(т/год)"
                +"\nВантажопідйомність: "+ cargoCapacity + "(т)"
                +"\nКількість пасажирських місць: "+ passengerCapacity
        );
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

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
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

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}
