package Commands.AircraftCommand;

import Airline.Airline;
import Commands.Command;

public class PlaneDelete implements Command {
    @Override
    public void execute(Airline airline){
        airline.PlaneDelete();
    }
}
