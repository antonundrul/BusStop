package by.undrul.busStop.comparator;

import by.undrul.busStop.entity.BusTrip;

import java.util.Comparator;

public class BusDepartureTimeComparator implements Comparator<BusTrip> {

    @Override
    public int compare(BusTrip o1, BusTrip o2) {
        int compare = o1.getDepartureTime().compareTo(o2.getDepartureTime());
        return compare;
    }
}
