package Commands.AirlineCommand;

import Airline.Airline;
import Commands.Command;

public class CreateAirline implements Command {
    @Override
    public void execute(Airline airline){
        airline.CreateAirline();
    }
}
