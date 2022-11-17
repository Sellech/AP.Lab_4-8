package Aircraft;

public class CargoPlane extends Plane {
    private int cargoCapacity;  // т

    public CargoPlane(String name, int flyDistance, double fuelConsumption, int cargoCapacity) {
        super(name, flyDistance, fuelConsumption);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}
