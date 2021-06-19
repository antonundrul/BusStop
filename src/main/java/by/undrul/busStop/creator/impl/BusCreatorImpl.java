package by.undrul.busStop.creator.impl;

import by.undrul.busStop.creator.BusCreator;
import by.undrul.busStop.entity.Bus;
import by.undrul.busStop.exception.BusSheduleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class BusCreatorImpl implements BusCreator {
    public static Logger logger = LogManager.getLogger();

    @Override
    public Bus createBus(String[] elements) throws BusSheduleException {
        logger.info("Method to create bus entity start");
        if (elements == null) {
            throw new BusSheduleException("Array of bus shedule elements is null");
        }
        LocalTime departureTime = LocalTime.parse(elements[1]);
        LocalTime arrivalTime = LocalTime.parse(elements[2]);
        Bus bus = new Bus(elements[0], departureTime, arrivalTime);

        logger.info("Object " + bus + " is created");
        return bus;
    }
}
