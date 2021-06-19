package by.undrul.busStop.writer.impl;

import by.undrul.busStop.entity.Bus;
import by.undrul.busStop.exception.BusSheduleException;
import by.undrul.busStop.validator.FileValidator;
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
    public void writeDataInFile(ArrayList<Bus> buses, String filepath) throws BusSheduleException {
        logger.info("Method to write data in file started");

        if (!FileValidator.isFileValid(filepath)) {
            throw new BusSheduleException("File " + filepath + " is empty or don't exist or has incorrect filepath");
        }

        try {
            File file = new File("./src/main/resources/data/output.txt");
            PrintWriter pw = new PrintWriter(file);
            for (Bus bus : buses) {
                if (bus.getBusCompany().equals("Posh"))
                    pw.println(bus);
            }
            pw.println();
            for (Bus bus : buses) {
                if (bus.getBusCompany().equals("Grotty"))
                    pw.println(bus);
            }
            pw.close();
            logger.info("Data written to file");
        } catch (FileNotFoundException ex) {
            logger.error("Error with specified file", ex);
        }
    }
}
