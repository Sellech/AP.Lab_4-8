package Commands.AirlineCommand;

import Airline.Airline;
import Commands.Command;


public class PlaneListSort implements Command {
    @Override
    public void execute(Airline airline){
        airline.PlaneListSort();
    }
}
