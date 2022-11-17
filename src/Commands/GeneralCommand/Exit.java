package Commands.GeneralCommand;

import Airline.Airline;
import Commands.Command;

public class Exit implements Command {
    @Override
    public void execute(Airline airline){
        System.exit(0);
    }
}
