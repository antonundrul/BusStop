package by.undrul.busStop.service;

import by.undrul.busStop.entity.Bus;

import java.util.ArrayList;

public interface BusService {
    ArrayList<Bus> transformSheduleToEfficient(ArrayList<Bus> buses);

    ArrayList<Bus> sortBusShedule(ArrayList<Bus> buses);
}
