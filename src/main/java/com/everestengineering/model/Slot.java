package com.everestengineering.model;

public class Slot {
    private SlotType slotType;
    private String regNumber,color,status;
    Slot(SlotType slotType, String status)
    {
        this.slotType = slotType;
        this.status = status;
    }
}
