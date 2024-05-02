package com.akash.lift.startapp;

import com.akash.lift.database.DataBase;
import com.akash.lift.model.Lift;

import java.util.ArrayList;
import java.util.List;

public class StartAppModel {
    private StartAppView startAppView;
    public StartAppModel(StartAppView startAppView){
        this.startAppView = startAppView;
    }

    public void assignLift(int pickUpPoint, int dropPoint, int capacity) {
        List<Lift> liftList = new ArrayList<>();
        for (Lift l : DataBase.getInstance().getLiftList()){
            if (l.getOnlyAllow().contains(pickUpPoint) && l.getOnlyAllow().contains(dropPoint) && l.isMaintainence()){
                liftList.add(l);
            }
        }
        while (capacity > 0){
            Lift assign = getAssignLift(liftList,pickUpPoint,dropPoint);
            assign.setCurrentPos(dropPoint);
            System.out.println(assign.getLiftName()+" is Assigned You");
            capacity = capacity-assign.getCapacity();
        }
    }

    public Lift getAssignLift(List<Lift> li,int pickupPoint,int dropPoint){
        Lift l = null;
        int max = Integer.MAX_VALUE;
        for (Lift lift : li){
            if (lift.getCurrentPos() == pickupPoint){
                return lift;
            }
            if (Math.abs(lift.getCurrentPos()-pickupPoint) < max) {
                l = lift;
            }
            max = Math.abs(lift.getCurrentPos()-pickupPoint);

        }
        return l;
    }

    public void setMaintanece(String liftName) {
        for (Lift l : DataBase.getInstance().getLiftList()){
            if (l.getLiftName().equals(liftName)){
                l.setMaintainence(false);
            }
        }
        startAppView.showAlert(liftName+"is changed to maintainence");
    }
}
