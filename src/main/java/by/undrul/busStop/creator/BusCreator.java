package by.undrul.busStop.creator;

import by.undrul.busStop.entity.BusTrip;
import by.undrul.busStop.exception.BusStopException;

public interface BusCreator {
    BusTrip createBusTrip(String[] elements) throws BusStopException;
}
