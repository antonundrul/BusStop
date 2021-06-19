package by.undrul.busStop.creator;

import by.undrul.busStop.entity.Bus;
import by.undrul.busStop.exception.BusSheduleException;

public interface BusCreator {
    Bus createBus(String[] elements) throws BusSheduleException;
}
