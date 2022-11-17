package Aircraft;

public class PassengerPlane extends Plane {
    private int passengerCapacity;

    public PassengerPlane(String name, int flyDistance, double fuelConsumption, int passengerCapacity) {
        super(name, flyDistance, fuelConsumption);
        this.passengerCapacity = passengerCapacity;
    }
}
