package com.everestengineering;

import com.everestengineering.design.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    ParkingLot system = new ParkingLot("PR1",1,4);
    Display board = new Display("TRUCK",system);

    @Test
    void displayCount() {
        assertEquals(1,board.displayCount("free_count"));

    }

}