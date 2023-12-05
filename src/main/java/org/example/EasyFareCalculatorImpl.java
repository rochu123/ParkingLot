package org.example;

public class EasyFareCalculatorImpl implements FareCalculator {
    @Override
    public double calculateFare(Ticket ticket) {
        return (double) (ticket.getEndTime() - ticket.getStartTime()) / 100;
    }
}
