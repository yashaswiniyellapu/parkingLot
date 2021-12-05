package com.everestengineering.model;

public abstract class Vehicle {
    private final String registrationNumber;
    private final String color;
    private final SlotType slotType;

    public Vehicle(String registrationId, String color, SlotType slotType) {
        this.registrationNumber = registrationId;
        this.color = color;
        this.slotType = slotType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public SlotType getSlotType() {
        return slotType;
    }
}
