package by.undrul.busStop._main;

import by.undrul.busStop.creator.BusCreator;
import by.undrul.busStop.creator.impl.BusCreatorImpl;
import by.undrul.busStop.entity.BusTrip;
import by.undrul.busStop.exception.BusStopException;
import by.undrul.busStop.parser.BusParser;
import by.undrul.busStop.parser.impl.BusParserImpl;
import by.undrul.busStop.reader.DataReader;
import by.undrul.busStop.reader.impl.DataReaderImpl;
import by.undrul.busStop.service.BusService;
import by.undrul.busStop.service.impl.BusServiceImpl;
import by.undrul.busStop.writer.DataWriter;
import by.undrul.busStop.writer.impl.DataWriterImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Set;

/**
 * Hello world!
 */
public class BusMain {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {


        DataReader reader = new DataReaderImpl();
        BusParser parser = new BusParserImpl();
        BusCreator creator = new BusCreatorImpl();
        DataWriter writer = new DataWriterImpl();
        BusService service = new BusServiceImpl();

        String filepath = "./src/main/resources/data/input.txt";

        ArrayList<BusTrip> buses = new ArrayList<>();

        try {
            ArrayList<String> datafromFile = reader.readDataFromFile(filepath);

            for(String line : datafromFile){
                String[] elements = parser.parseBuses(line);
                BusTrip bus =  creator.createBusTrip(elements);
                buses.add(bus);
            }

        } catch (BusStopException e) {
            e.printStackTrace();
        }

        ArrayList<BusTrip> newBuses = service.transformToEfficient(buses);
        newBuses = service.sortBusShedule(newBuses);
        logger.info(newBuses);
        writer.writeDataInFile(newBuses);
    }
}
