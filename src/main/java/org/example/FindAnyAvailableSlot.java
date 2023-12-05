package org.example;

import java.util.List;

import static org.example.SlotStatus.FREE;

public class FindAnyAvailableSlot implements SlotFinder {
    @Override
    public Slot findSlot(List<Slot> slots) {
        for (Slot slot : slots) {
            if (FREE.equals(slot.getStatus())) {
                return slot;
            }
        }
        throw new RuntimeException("no available slot");
    }
}
