package com.akash.lift.model;

import java.util.ArrayList;
import java.util.List;

public class Lift {

    private String liftName;
    private boolean isMaintainence;
    private int currentPos;
    private int capacity;
    private List<Integer> onlyAllow;

    public List<Integer> getOnlyAllow() {
        return onlyAllow;
    }

    public void setOnlyAllow(List<Integer> onlyAllow) {
        this.onlyAllow = onlyAllow;
    }

    public String getLiftName() {
        return liftName;
    }

    public void setLiftName(String liftName) {
        this.liftName = liftName;
    }

    public boolean isMaintainence() {
        return isMaintainence;
    }

    public void setMaintainence(boolean maintainence) {
        isMaintainence = maintainence;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
