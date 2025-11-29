package com.barlinc.seafarer.entities.interfaces;

public interface ISemiAquatic {

    boolean shouldEnterWater();

    boolean shouldLeaveWater();

    boolean shouldStopMoving();

    int getWaterSearchRange();
}
