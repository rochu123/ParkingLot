package org.example;

public class ExitGate {
    private String id;
    private String floorId;
    private FareCalculator fareCalculator;

    public double getFare(Ticket ticket) {
        return fareCalculator.calculateFare(ticket);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public FareCalculator getFareCalculator() {
        return fareCalculator;
    }

    public void setFareCalculator(FareCalculator fareCalculator) {
        this.fareCalculator = fareCalculator;
    }
}
