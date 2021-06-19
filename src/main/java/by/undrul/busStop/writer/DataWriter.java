package by.undrul.busStop.writer;

import by.undrul.busStop.entity.BusTrip;

import java.util.ArrayList;

public interface DataWriter {
    void writeDataInFile(ArrayList<BusTrip> buses);
}
