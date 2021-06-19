package by.undrul.busStop.parser.impl;

import by.undrul.busStop.parser.BusParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BusParserImpl implements BusParser {
    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_SPLIT = "\\s+";

    @Override
    public String[] parseBuses(String line) {
        logger.info("Method to parse lines start");
        String[] elements = line.split(REGEX_FOR_SPLIT);

        return elements;
    }
}
