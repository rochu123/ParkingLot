package org.example;

import java.util.UUID;

public class Ticket {
    private String id;
    private long startTime;
    private long endTime;
    private String slotId;

    public Ticket(String slotId) {
        this.id = UUID.randomUUID().toString();
        this.startTime = System.currentTimeMillis();
        this.slotId = slotId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }
}
