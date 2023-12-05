package org.example;

import static java.util.UUID.randomUUID;
import static org.example.SlotStatus.FREE;

public class Main {
    public static void main(String[] args) {
        String floorId = "FLOOR_0";

        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNumber(1);
        parkingFloor.setId(floorId);

        Slot slot1 = new Slot();
        slot1.setId(randomUUID().toString());
        slot1.setStatus(FREE);
        slot1.setFloorId(floorId);
        slot1.setNumber(0);

        Slot slot2 = new Slot();
        slot2.setId(randomUUID().toString());
        slot2.setStatus(FREE);
        slot2.setFloorId(floorId);
        slot2.setNumber(0);

        ExitGate exitGate = new ExitGate();
        FareCalculator fareCalculator = new EasyFareCalculatorImpl();
        exitGate.setFareCalculator(fareCalculator);
        exitGate.setId(randomUUID().toString());
        exitGate.setFloorId(floorId);


        SlotManager slotManager = new SlotManager();
        SlotFinder slotFinder = new FindAnyAvailableSlot();
        slotManager.addSlot(slot1);
        slotManager.addSlot(slot2);
        slotManager.addParkingFLoor(parkingFloor);
        slotManager.setSlotFinder(slotFinder);

        EntryGate entryGate = new EntryGate();
        entryGate.setId(randomUUID().toString());


        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addExitGate(exitGate);
        parkingLot.setEntryGate(entryGate);
        parkingLot.setSlotManager(slotManager);

        VehicleDetails vehicleDetails = new VehicleDetails();
        vehicleDetails.setVehicleNumber("PBO3V3194");

        Ticket ticket = parkingLot.findSlotAndGenerateTicket(vehicleDetails);
        System.out.println("Ticket " + ticket.getSlotId() + " " + ticket.getId());
        try {
            System.out.println("sleeping");
            Thread.sleep(2000);
        } catch (Exception ignored) {

        }
        double fare = parkingLot.getFareAndFreeSlot(ticket, exitGate.getId());

        Ticket ticket1 = parkingLot.findSlotAndGenerateTicket(vehicleDetails);
        System.out.println("Ticket " + ticket1.getSlotId() + " " + ticket1.getId());

        Ticket ticket2 = parkingLot.findSlotAndGenerateTicket(vehicleDetails);
        System.out.println("Ticket " + ticket2.getSlotId() + " " + ticket2.getId());

//        Ticket ticket3 = parkingLot.findSlotAndGenerateTicket(vehicleDetails);// will throw exception
//        System.out.println("Ticket " + ticket3.getSlotId() + " " + ticket3.getId());


        double fare1 = parkingLot.getFareAndFreeSlot(ticket1, exitGate.getId());
        double fare2 = parkingLot.getFareAndFreeSlot(ticket2, exitGate.getId());
        System.out.println("fare is " + fare);
        System.out.println("fare is " + fare1);
        System.out.println("fare is " + fare2);


        System.out.println("Hello world!");
    }
}