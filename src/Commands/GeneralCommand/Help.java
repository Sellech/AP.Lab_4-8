package Commands.GeneralCommand;

import Airline.Airline;
import Commands.Command;

public class Help implements Command {
    @Override
    public void execute(Airline airline) throws Exception {
        airline.Help();
    }
}
