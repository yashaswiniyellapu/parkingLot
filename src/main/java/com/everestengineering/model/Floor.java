package com.everestengineering.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private  int getNumOfSlots;
    private List<Slot> spaceList = new ArrayList<>();
    Floor(int getNumOfSlots)
    {
        this.getNumOfSlots = getNumOfSlots;
        createFloor(getNumOfSlots);
    }
    public void createFloor(int numOfSlots) {
        for (int i=0; i<numOfSlots; i++)
        {
            if(i==0)
            {
                spaceList.add(i,new Slot(SlotType.TRUCK,"unparked"));
            }
            else if(i==1 || i==2)
            {
                spaceList.add(i,new Slot(SlotType.BIKE,"unparked"));
            }
            else
            {
                spaceList.add(i,new Slot(SlotType.CAR,"unparked"));
            }
        }
    }
}
