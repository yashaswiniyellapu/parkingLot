package com.everestengineering.design;

import com.everestengineering.Display;
import com.everestengineering.model.Floor;
import com.everestengineering.model.Slot;
import com.everestengineering.servicetype.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final String parkLotId;
    private final int numOfFloors;
    protected int numOfSlots;
    protected List<List<Slot>> floorList = new ArrayList<>();

    public ParkingLot(String parkLotId, int numOfFloors, int numOfSlots) {
        this.parkLotId = parkLotId;
        this.numOfFloors = numOfFloors;
        this.numOfSlots = numOfSlots;
        buildParkLot(numOfFloors);
    }

    public void buildParkLot(int numOfFloors) {
        for (int i = 0; i < numOfFloors; i++) {
            Floor increment = new Floor(numOfSlots);
            floorList.add(i, increment.getSpaceList());
        }
    }

    public void park(Vehicle vehicle) {
        boolean isValid = false;
        for (int i = 0; i < getNumOfFloors(); i++) {
            for (int j = 0; j < getNumOfSlots(); j++) {
                if (getFloorList().get(i).get(j).getSlotType().toString().equalsIgnoreCase(vehicle.getVehicleType())) {
                    if (getFloorList().get(i).get(j).getStatus().equals("unparked")) {
                        System.out.println("Vehicle is parked TicketID:" + getParkLotId() + "_" + i + "_" + j);
                        vehicle.registerData(i, j);
                        isValid = true;
                        break;
                    }
                }
            }
            if (isValid) {
                break;
            }

        }
        if(!isValid)
        {isParkLotFull();}



    }

    public void isParkLotFull() {
        if (!getFloorList().get(numOfFloors - 1).get(0).getStatus().equals("unparked")) {
            System.out.println("Parklot is full");
        } else if (!getFloorList().get(numOfFloors - 1).get(2).getStatus().equals("unparked")) {
            System.out.println("Parklot is full");
        } else if (!getFloorList().get(numOfFloors - 1).get(numOfSlots - 1).getStatus().equals("unparked")) {
            System.out.println("Parklot is full");
        }
    }


    public void unPark(String ticketId) {
        String[] ticket = ticketId.split("_", -1);
        if (Integer.parseInt(ticket[1]) < getNumOfFloors() && Integer.parseInt(ticket[2]) < numOfSlots) {
            System.out.println("Unparked Vehicle ID and color is: " + getFloorList().get(Integer.parseInt(ticket[1])).get(Integer.parseInt(ticket[2])).getStatus());
            getFloorList().get(Integer.parseInt(ticket[1])).get(Integer.parseInt(ticket[2])).setStatus("unparked");
        } else {
            System.out.println("Invalid Ticket");
        }
    }

    public void display(String type, String vehicleName) {
        Display object = new Display(vehicleName, this);
        if (type.contains("count")) {
            object.displayCount(type);
        } else {
            object.displaySlots(type);
        }
    }

    public List<List<Slot>> getFloorList() {
        return floorList;
    }

    public String getParkLotId() {
        return parkLotId;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public int getNumOfSlots() {
        return numOfSlots;
    }
}
