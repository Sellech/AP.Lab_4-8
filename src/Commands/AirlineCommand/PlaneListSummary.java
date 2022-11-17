package Commands.AirlineCommand;

import Airline.Airline;
import Commands.Command;


public class PlaneListSummary implements Command {
    @Override
    public void execute(Airline airline){
        airline.PlaneListSummary();
    }
}
