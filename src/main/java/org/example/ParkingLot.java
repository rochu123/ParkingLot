package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class ParkingLot {
    private EntryGate entryGate;
    private List<ExitGate> exitGates;


    private SlotManager slotManager;

    public Ticket findSlotAndGenerateTicket(VehicleDetails vehicleDetails) {
        return slotManager.findAvailableSlotAndGenerateTicket(vehicleDetails);
    }


    public double getFareAndFreeSlot(Ticket ticket, String exitGateId) {
        ExitGate exitGate = getExitGateById(exitGateId);
        slotManager.freeOccupiedSlot(ticket.getSlotId());
        ticket.setEndTime(System.currentTimeMillis());
        return exitGate.getFare(ticket);
    }

    private ExitGate getExitGateById(String id) {
        for (ExitGate exitGate : this.exitGates) {
            if (exitGate.getId().equals(id)) {
                return exitGate;
            }
        }
        throw new RuntimeException("invalid id");
    }

    public ExitGate addExitGate(ExitGate exitGate) {
        // need validation's here
        if (isNull(this.exitGates)) {
            exitGates = new ArrayList<>();
        }
        exitGates.add(exitGate);
        return exitGate;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public void setSlotManager(SlotManager slotManager) {
        this.slotManager = slotManager;
    }
}
