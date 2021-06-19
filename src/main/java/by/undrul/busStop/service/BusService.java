package by.undrul.busStop.service;

import by.undrul.busStop.entity.BusTrip;

import java.util.ArrayList;
import java.util.Comparator;

public interface BusService {
    ArrayList<BusTrip> transformToEfficient(ArrayList<BusTrip> buses);

    ArrayList<BusTrip> sortBusShedule(ArrayList<BusTrip> buses);
}
