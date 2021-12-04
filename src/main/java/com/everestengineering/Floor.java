package com.everestengineering;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Slot> spaceList = new ArrayList<>();
    public void createTruckSpace()
    {
        for(int i=0; i<1; i++)
        {
            spaceList.add(new Slot(SlotType.TRUCK,"unparked"));
        }
    }
    public void createBikeSpace()
    {
        for(int i=1; i<=2; i++)
        {
            spaceList.add(new Slot(SlotType.TRUCK,"unparked"));
        }
    }
    public void createCarSpace()
    {
        for(int i=3; i<numOfSlots; i++)
        {
            spaceList.add(new Slot(SlotType.TRUCK,"unparked"));
        }
    }
}
