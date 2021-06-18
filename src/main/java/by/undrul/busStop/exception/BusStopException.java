package by.undrul.busStop.exception;

public class BusStopException extends Exception{
    public BusStopException() {
    }

    public BusStopException(String message) {
        super(message);
    }

    public BusStopException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusStopException(Throwable cause) {
        super(cause);
    }
}
