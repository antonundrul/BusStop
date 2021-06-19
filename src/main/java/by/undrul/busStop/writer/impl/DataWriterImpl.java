package by.undrul.busStop.writer.impl;

import by.undrul.busStop.entity.BusTrip;
import by.undrul.busStop.writer.DataWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataWriterImpl implements DataWriter {
    public static Logger logger = LogManager.getLogger();

    @Override
    public void writeDataInFile(ArrayList<BusTrip> buses) {

        try {
            File file = new File("./src/main/resources/data/output.txt");
            PrintWriter pw = new PrintWriter(file);
            for (BusTrip bus : buses) {
                if(bus.getBusCompany().equals("Posh"))
                pw.println(bus);
            }
            pw.println();
            for (BusTrip bus : buses) {
                if(bus.getBusCompany().equals("Grotty"))
                pw.println(bus);
            }
            pw.close();
            logger.info("Object written to file");
        } catch (FileNotFoundException ex) {
            logger.error("Error with specified file");
            ex.printStackTrace();
        }
    }
}
