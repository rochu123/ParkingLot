package org.example;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.example.SlotStatus.FREE;
import static org.example.SlotStatus.OCCUPIED;

public class SlotManager {

    private List<ParkingFloor> parkingFloors;
    private List<Slot> slots;
    private SlotFinder slotFinder;


    public Ticket findAvailableSlotAndGenerateTicket(VehicleDetails vehicleDetails) {
        Slot slot = slotFinder.findSlot(slots);
        slot.setVehicleDetails(vehicleDetails);
        slot.setStatus(OCCUPIED);
        return new Ticket(slot.getId());
    }

    public Slot freeOccupiedSlot(String slotId){
        Slot slot = getSlotById(slotId);
        slot.setStatus(FREE);
        slot.setVehicleDetails(null);
        return slot;
    }

    public Slot addSlot(Slot slot) {
        // need validation's here
        if (isNull(this.slots)) {
            slots = new ArrayList<>();
        }
        slots.add(slot);
        return slot;
    }


    public Slot getSlotById(String id) {
        for (Slot slot : slots) {
            if (slot.getId().equals(id)) {
                return slot;
            }
        }
        return null;
    }

    public ParkingFloor addParkingFLoor(ParkingFloor parkingFloor) {
        if (isNull(this.parkingFloors)) {
            parkingFloors = new ArrayList<>();
        }
        parkingFloors.add(parkingFloor);
        return parkingFloor;
    }

    public SlotFinder getSlotFinder() {
        return slotFinder;
    }

    public void setSlotFinder(SlotFinder slotFinder) {
        this.slotFinder = slotFinder;
    }

}
