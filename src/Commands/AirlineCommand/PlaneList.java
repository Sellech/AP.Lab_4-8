package Commands.AirlineCommand;

import Airline.Airline;
import Commands.Command;


public class PlaneList implements Command {
    @Override
    public void execute(Airline airline){
        airline.PlaneList();
    }
}
