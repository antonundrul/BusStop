package by.undrul.busStop.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineValidator {
    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_SPLIT = "\\s+";
    private static final String REGEX_FOR_LINE = "[a-zA-z]\\s+";
    public static final int AMOUNT_OF_ELEMENTS = 3;

    public static boolean isLineValid(String line) {
        logger.info("Method to validate line start");

        boolean isVal = false;
        String[] elements = line.split(REGEX_FOR_SPLIT);
        if (elements.length == AMOUNT_OF_ELEMENTS) {
            isVal = true;
        } else {
            logger.info("The string " + line + " has not enough parameters " + elements.length);
        }

        return isVal;

    }
}
