package Commands.AirlineCommand;

import Airline.Airline;
import Commands.Command;


public class PlaneListRange implements Command {
    @Override
    public void execute(Airline airline){
        airline.PlaneListRange();
    }
}
