package Commands;

import Airline.Airline;

public interface Command {
    void execute(Airline airline) throws Exception;
}
