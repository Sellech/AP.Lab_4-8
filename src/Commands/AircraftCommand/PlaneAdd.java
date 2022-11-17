package Commands.AircraftCommand;

import Airline.Airline;
import Commands.Command;

public class PlaneAdd implements Command {
    @Override
    public void execute(Airline airline){
        airline.PlaneAdd();
    }
}
