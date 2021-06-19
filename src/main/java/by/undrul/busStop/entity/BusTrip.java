package by.undrul.busStop.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.MINUTES;

public class BusTrip implements Serializable {
    private String busCompany;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    public BusTrip() {
    }

    public BusTrip(String busCompany, LocalTime departureTime, LocalTime arrivalTime) {
        this.busCompany = busCompany;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getBusCompany() {
        return busCompany;
    }

    public void setBusCompany(String busCompany) {
        this.busCompany = busCompany;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getDuration() {
        long duration = MINUTES.between(departureTime, arrivalTime);
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusTrip busTrip = (BusTrip) o;
        return busCompany == busTrip.busCompany && Objects.equals(departureTime, busTrip.departureTime) && Objects.equals(arrivalTime, busTrip.arrivalTime);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + busCompany.hashCode();
        result = result * prime + departureTime.hashCode();
        result = result * prime + arrivalTime.hashCode();

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(busCompany).append("  ").append(departureTime.toString()).append("  ").append(arrivalTime);
        return sb.toString();
    }

}


