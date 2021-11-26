package com.everestengineering.model;

public class Slot {
    private final SlotType slotType;
    private String status;

    public Slot(SlotType slotType, String status) {
        this.slotType = slotType;
        this.status = status;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
