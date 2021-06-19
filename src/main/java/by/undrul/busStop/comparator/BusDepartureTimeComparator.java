package by.undrul.busStop.comparator;

import by.undrul.busStop.entity.Bus;

import java.util.Comparator;

public class BusDepartureTimeComparator implements Comparator<Bus> {

    @Override
    public int compare(Bus o1, Bus o2) {
        int compare = o1.getDepartureTime().compareTo(o2.getDepartureTime());
        return compare;
    }
}
