package by.undrul.busStop.creator.impl;

import by.undrul.busStop.creator.BusCreator;
import by.undrul.busStop.entity.BusTrip;
import by.undrul.busStop.exception.BusStopException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class BusCreatorImpl implements BusCreator {
    public static Logger logger = LogManager.getLogger();

    @Override
    public BusTrip createBusTrip(String[] elements) throws BusStopException {
        logger.info("Method to create bus entity start");
        BusTrip busTrip = new BusTrip();
        LocalTime departureTime = LocalTime.parse(elements[1]);
        LocalTime arrivalTime = LocalTime.parse(elements[2]);
        busTrip.setBusCompany(elements[0]);
        busTrip.setDepartureTime(departureTime);
        busTrip.setArrivalTime(arrivalTime);

        logger.info("Object " + busTrip + " is created");
        return busTrip;

    }
}
