package com.everestengineering;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String parklotId;
    private int numOfFloors;
    private int numOfSlots;
    static List<List<Slot>> floorSpace = new ArrayList<>();

    public ParkingLot(String parklotId, int numOfFloors, int numOfSlots) {
        this.parklotId = parklotId;
        this.numOfFloors = numOfFloors;
        this.numOfSlots = numOfSlots;
        build();
    }

    public void build() {
        for (int i = 0; i < numOfFloors; i++) {
            Floor floor = new Floor(numOfSlots);
            floorSpace.add(i, floor.getSpaceList());
        }
    }

    public void park(Vehicle vehicle) {
        ValidateSpace validateSpace = new ValidateSpace(vehicle.getSlotType());
        boolean checkFloor = validateSpace.checkFloor();
        if (checkFloor) {
            int[] position = validateSpace.getPosition();
            System.out.println("Parked vehicle. TicketId " + parklotId + "_" + position[0] + "_" + position[1]);
            floorSpace.get(position[0]).get(position[1]).setStatus(vehicle.getRegistrationId() + " " + vehicle.getColor());
        }
        if (!checkFloor) {
            System.out.println("Parklot is full");
        }

    }

    public void unPark(String ticketId) {
        String[] ticket = ticketId.split("_");
        String[] data = floorSpace.get(Integer.parseInt(ticket[1])).get(Integer.parseInt(ticket[2])).getStatus().split(" ");
        System.out.println("Unparked vehicle with Registration number " + data[0] + " and color " + data[1]);
        floorSpace.get(Integer.parseInt(ticket[1])).get(Integer.parseInt(ticket[2])).setStatus("unparked");
    }
    public void display(Display display)
    {
        if(display.getTypeOfSpace().contains("slots"))
        {
            Map<Integer, List> floorMap = display.getSlots1();
            floorMap.keySet().stream().forEach(key-> System.out.println(display.getTypeOfSpace()
                    +"slots "+"for "
                    +display.getSlotType()
                    +" on Floor "
                    + key+":"+floorMap.get(key)));
        }
        if(display.getTypeOfSpace().contains("count"))
        {
            Map<Integer, List> floorMap = display.getSlots1();
            floorMap.keySet().stream().forEach(key-> System.out.println("No. of "
                    +display.getTypeOfSpace()
                    +"slots "+"for "
                    +display.getSlotType()
                    +" on Floor "
                    + key+":"+floorMap.get(key).size()));
        }

    }

}
