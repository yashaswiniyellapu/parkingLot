package com.everestengineering;

public class Slot {
    private SlotType slotType;
    private String status;

    public Slot(SlotType slotType, String status) {
        this.slotType = slotType;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SlotType getSlotType() {
        return slotType;
    }

}
