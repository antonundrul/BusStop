package by.undrul.busStop.writer;

import by.undrul.busStop.entity.Bus;
import by.undrul.busStop.exception.BusSheduleException;

import java.util.ArrayList;

public interface DataWriter {
    void writeDataInFile(ArrayList<Bus> buses, String filepath) throws BusSheduleException;
}
