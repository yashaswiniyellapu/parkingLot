package com.everestengineering.design;

import com.everestengineering.model.Slot;
import com.everestengineering.servicetype.Truck;
import com.everestengineering.servicetype.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.everestengineering.model.SlotType.TRUCK;
import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    ParkingLot parkingLot = new ParkingLot("yesh = new yesh()",2,4);
    Vehicle vehicle;

    @Test
    void buildParkLot() {
        List<List<Slot>> floorTestList = parkingLot.getFloorList();
        assertEquals(2, floorTestList.size());
    }

    @Test
    void park() {
        vehicle = new Truck(parkingLot,"xxxxx","Balck","TRUCK");
        assertEquals("TRUCK",vehicle.getVehicleType());
        assertEquals(TRUCK,parkingLot.getFloorList().get(0).get(0).getSlotType());
    }

    @Test
    void unPark() {
        parkingLot.unPark("new yesh()_0_0");
        assertEquals("unparked",parkingLot.getFloorList().get(0).get(0).getStatus());
    }
}