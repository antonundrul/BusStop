package by.undrul.busStop._main;

import by.undrul.busStop.creator.BusCreator;
import by.undrul.busStop.creator.impl.BusCreatorImpl;
import by.undrul.busStop.entity.Bus;
import by.undrul.busStop.exception.BusSheduleException;
import by.undrul.busStop.parser.BusParser;
import by.undrul.busStop.parser.impl.BusParserImpl;
import by.undrul.busStop.reader.DataReader;
import by.undrul.busStop.reader.impl.DataReaderImpl;
import by.undrul.busStop.service.BusService;
import by.undrul.busStop.service.impl.BusServiceImpl;
import by.undrul.busStop.writer.DataWriter;
import by.undrul.busStop.writer.impl.DataWriterImpl;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class BusMain {
    public static void main(String[] args) {

        DataReader reader = new DataReaderImpl();
        BusParser parser = new BusParserImpl();
        BusCreator creator = new BusCreatorImpl();
        DataWriter writer = new DataWriterImpl();
        BusService service = new BusServiceImpl();

        String inputFile = "./src/main/resources/data/input.txt";
        String outputFile = "./src/main/resources/data/output.txt";

        ArrayList<Bus> buses = new ArrayList<>();

        try {
            ArrayList<String> datafromFile = reader.readDataFromFile(inputFile);

            for (String line : datafromFile) {
                String[] elements = parser.parseBuses(line);
                Bus bus = creator.createBus(elements);
                buses.add(bus);
            }

        } catch (BusSheduleException e) {
            e.printStackTrace();
        }

        ArrayList<Bus> newShedule = service.transformSheduleToEfficient(buses);
        newShedule = service.sortBusShedule(newShedule);

        try {
            writer.writeDataInFile(newShedule, outputFile);
        } catch (BusSheduleException e) {
            e.printStackTrace();
        }
    }
}
