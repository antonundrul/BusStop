package by.undrul.busStop.reader;

import by.undrul.busStop.exception.BusStopException;

import java.util.ArrayList;

public interface DataReader {
    ArrayList<String> readDataFromFile(String path) throws BusStopException;
}
