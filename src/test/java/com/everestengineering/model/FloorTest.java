package com.everestengineering.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {
    @Test
    public void createFloorTest()
    {
        Floor f1 = new Floor(4);
        List<Slot> testList = f1.getSpaceList();
        assertEquals(4,testList.size());
    }


}