package com.everestengineering.validation;

import com.everestengineering.model.Slot;
import com.everestengineering.model.SlotType;
import com.everestengineering.parkspace.ParkingLot;

import java.util.List;


public class ValidateSpace {
    private SlotType slotType;
    private int[] position;
    private boolean isContains = false;
    private boolean checkFloor = false;

    public ValidateSpace(SlotType slotType) {
        this.slotType = slotType;
        position = new int[2];
    }

    public boolean checkFloor() {
        for (int i = 0; i < ParkingLot.getFloorSpace().size(); i++) {
            boolean checkSlot = checkSlot(ParkingLot.getFloorSpace().get(i));
            checkFloor = checkSlot;
            if (checkSlot) {
                break;
            }
        }
        return checkFloor;
    }

    public boolean checkSlot(List<Slot> list) {
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getSlotType().equals(slotType)) {
                if (list.get(j).getStatus().equals("unparked")) {
                    position[0] = ParkingLot.getFloorSpace().indexOf(list);
                    position[1] = j;
                    isContains = true;
                    break;
                }
            }
        }
        return isContains;
    }

    public int[] getPosition() {
        return position;
    }
}
