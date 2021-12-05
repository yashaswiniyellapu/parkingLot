package com.everestengineering;

import java.util.List;
import java.util.Map;

public interface Display {
    Map<Integer, List> getSlotsLoop1();

    List<Integer> getSlotsLoop2(List<Slot> list);

    String getTypeOfSpace();

    String getSlotType();
}
