package com.everestengineering;

import java.util.List;
import java.util.Map;

public interface Display {
    Map<Integer, List> getSlots1();
    List<Integer> getSlots2(List<Slot> list);
    String getTypeOfSpace();

    String getSlotType();
}
