package Commands.GeneralCommand;

import Airline.Airline;
import Commands.Command;

public class ProgramInfo implements Command {
    @Override
    public void execute(Airline airline){
        airline.ProgramInfo();
    }
}
