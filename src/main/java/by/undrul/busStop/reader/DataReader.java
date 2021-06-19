package by.undrul.busStop.reader;

import by.undrul.busStop.exception.BusSheduleException;

import java.util.ArrayList;

public interface DataReader {
    ArrayList<String> readDataFromFile(String path) throws BusSheduleException;
}
