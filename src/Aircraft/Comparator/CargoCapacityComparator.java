package Aircraft.Comparator;

import Aircraft.Plane;
import java.util.Comparator;

public class CargoCapacityComparator implements Comparator<Plane>{
    @Override
    public int compare(Plane p1, Plane p2){
        return (int)(p2.getCargoCapacity() - p1.getCargoCapacity());
    }
}