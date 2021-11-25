package com.everestengineering.servicetype;

import com.everestengineering.design.ParkingLot;

public class Bike implements Vehicle {
    private String regNumber;
    private String color;
    private String vehicletype;
    private ParkingLot parkingLot;

    public Bike(ParkingLot parkingLot, String regNumber, String color, String vehicletype) {
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
