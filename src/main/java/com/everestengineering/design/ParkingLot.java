package com.everestengineering.design;

import com.everestengineering.Display;
import com.everestengineering.model.Floor;
import com.everestengineering.model.Slot;
import com.everestengineering.servicetype.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
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
            Floor inc = new Floor(numOfSlots);
            floorList.add(i, inc.getSpaceList());
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
        if(!getFloorList().contains("unparked")){System.out.println("Parklot is Full");}
    }

    public void unPark(String ticketId) {
        String[] str = ticketId.split("_", -1);
        if(Integer.parseInt(str[1])<getNumOfFloors()&&Integer.parseInt(str[2])<numOfSlots) {
            System.out.println("Unparked Vehicle ID and color is: " + getFloorList().get(Integer.parseInt(str[1])).get(Integer.parseInt(str[2])).getStatus());
            getFloorList().get(Integer.parseInt(str[1])).get(Integer.parseInt(str[2])).setStatus("unparked");
        }
        else {System.out.println("Invalid Ticket");}
    }
    public void display(String type,String vehicleName)
    {
        Display object = new Display(vehicleName,this);
        if(type.contains("count")){object.displayCount(type);}
        else{object.displaySlots(type);}
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
