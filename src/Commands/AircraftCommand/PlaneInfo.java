package Commands.AircraftCommand;

import Airline.Airline;
import Commands.Command;

public class PlaneInfo implements Command {
    @Override
    public void execute(Airline airline){
        airline.PlaneInfo();
    }
}
