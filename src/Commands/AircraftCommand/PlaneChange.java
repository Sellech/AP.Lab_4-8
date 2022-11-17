package Commands.AircraftCommand;

import Airline.Airline;
import Commands.Command;

public class PlaneChange implements Command {
    @Override
    public void execute(Airline airline){
        airline.PlaneChange();
    }
}
