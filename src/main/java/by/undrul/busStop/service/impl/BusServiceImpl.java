package by.undrul.busStop.service.impl;

import by.undrul.busStop.comparator.BusDepartureTimeComparator;
import by.undrul.busStop.entity.Bus;
import by.undrul.busStop.service.BusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BusServiceImpl implements BusService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public ArrayList<Bus> transformSheduleToEfficient(ArrayList<Bus> buses) {
        ArrayList<Bus> newBusShedule = new ArrayList<>();

        for (int i = 0; i < buses.size(); i++) {
            boolean isEfficient = true;
            if (buses.get(i).getDuration() > 60) {
                isEfficient = false;
                logger.info(buses.get(i) + " has duration > 60 min");
            }
            for (int j = 0; j < buses.size(); j++) {

                if (buses.get(i).getDepartureTime().equals(buses.get(j).getDepartureTime())) {
                    if (buses.get(i).getArrivalTime().equals(buses.get(j).getArrivalTime())
                            && !buses.get(i).getBusCompany().equals(buses.get(j).getBusCompany())) {
                        if (!buses.get(i).getBusCompany().equals("Posh")) {
                            isEfficient = false;
                        }
                    }

                    if (buses.get(i).getArrivalTime().isAfter(buses.get(j).getArrivalTime())) {
                        isEfficient = false;
                    }
                }

                if (buses.get(i).getDepartureTime().isBefore(buses.get(j).getDepartureTime())) {
                    if (buses.get(i).getArrivalTime().isAfter(buses.get(j).getArrivalTime())
                            || buses.get(i).getArrivalTime().equals(buses.get(j).getArrivalTime())) {
                        isEfficient = false;
                    }
                }
            }

            if (isEfficient) {
                newBusShedule.add(buses.get(i));
            }
        }
        return newBusShedule;
    }

    @Override
    public ArrayList<Bus> sortBusShedule(ArrayList<Bus> buses) {
        BusDepartureTimeComparator departureTimeComparator = new BusDepartureTimeComparator();
        ArrayList<Bus> result = (ArrayList<Bus>) buses.stream().sorted(departureTimeComparator).collect(Collectors.toList());

        return result;
    }
}
