package com.everestengineering;

abstract class Vehicle {
    private String registrationId;
    private String color;
    private SlotType slotType;

    protected Vehicle(String registrationId, String color, SlotType slotType) {
        this.registrationId = registrationId;
        this.color = color;
        this.slotType = slotType;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getColor() {
        return color;
    }

    public SlotType getSlotType() {
        return slotType;
    }
}
