package com.everestengineering.design;

import com.everestengineering.model.Floor;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String parkLotId;
    private int numOfFloors;
    private int numOfSlots;
    private List<List> floorList = new ArrayList<>();

    public ParkingLot(String parkLotId, int numOfFloors, int numOfSlots)
    {
        this.parkLotId = parkLotId;
        this.numOfFloors = numOfFloors;
        this.numOfSlots = numOfSlots;
        buildParkLot(numOfFloors);
    }


    public void buildParkLot(int numOfFloors)
    {
       for(int i=0; i<numOfFloors; i++)
       {
           Floor object = new Floor(numOfSlots);
           floorList.add(i, object.getSpaceList());
       }
    }
    public List<List> getFloorList()
    {
        return floorList;
    }
}
