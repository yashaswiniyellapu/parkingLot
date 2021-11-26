package com.everestengineering.servicetype;

import com.everestengineering.design.ParkingLot;

public class Truck implements Vehicle {
    private final String regNumber;
    private final String color;
    private final String vehicletype;
    private final ParkingLot parkingLot;

    public Truck(ParkingLot parkingLot, String regNumber, String color, String vehicletype) {
        this.vehicletype = vehicletype;
        this.regNumber = regNumber;
        this.color = color;
        this.parkingLot = parkingLot;
    }

    @Override
    public void registerData(int floor, int slot) {
        parkingLot.getFloorList().get(floor).get(slot).setStatus(regNumber + " " + color);
    }

    @Override
    public String getVehicleType() {
        return vehicletype;
    }

}
