package Commands.AirlineCommand;

import Airline.Airline;
import Commands.Command;

public class AirlineInfo implements Command {
    @Override
    public void execute(Airline airline){
        airline.AirlineInfo();
    }
}
