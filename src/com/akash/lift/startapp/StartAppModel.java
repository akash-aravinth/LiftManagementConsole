package com.akash.lift.startapp;

import com.akash.lift.database.DataBase;
import com.akash.lift.model.Lift;

import java.security.Key;
import java.util.*;

public class StartAppModel {
    private StartAppView startAppView;

    public StartAppModel(StartAppView startAppView) {
        this.startAppView = startAppView;
    }

    //Module Two is Completed-------------------------------------
    public void assignLift(int pickUpPoint, int dropPoint, int capacity) {
        List<Lift> liftList = new ArrayList<>();
        for (Lift l : DataBase.getInstance().getLiftList()) {
            if (l.getOnlyAllow().contains(pickUpPoint) && l.getOnlyAllow().contains(dropPoint) && l.isMaintainence()) {
                liftList.add(l);
            }
        }
        System.out.println(liftList.getFirst().getLiftName() + " : is Assigned You");
        liftList.get(0).setCurrentPos(dropPoint);
    }

    public void setMaintanece(String liftName) {
        for (Lift l : DataBase.getInstance().getLiftList()) {
            if (l.getLiftName().equals(liftName)) {
                l.setMaintainence(false);
                l.setCurrentPos(-1);
            }
        }
        startAppView.showAlert(liftName + "is changed to maintainence");
    }

    //Module Three is Completed-----------------------------------------
    public void assignNearestLift(int pickUpPoint, int dropPoint, int capacity) {
        List<Lift> liftList = new ArrayList<>();
        for (Lift l : DataBase.getInstance().getLiftList()) {
            if (l.getOnlyAllow().contains(pickUpPoint) && l.getOnlyAllow().contains(dropPoint) && l.isMaintainence()) {
                liftList.add(l);
            }
        }
        Lift lift = null;
        int diff = Integer.MAX_VALUE;
        for (Lift l : liftList) {
            if (Math.abs(l.getCurrentPos() - pickUpPoint) < diff) {
                lift = l;
                diff = Math.abs(l.getCurrentPos() - pickUpPoint);
            }
        }
        if (lift != null) {
            System.out.println(lift.getLiftName() + " : is Assigned You ");
            lift.setCurrentPos(dropPoint);
        } else
            System.out.println("Lifts are in maintainence try again later");
    }

    //Module Four is Completed-----------------
    public void assignSameDirection(int pickUpPoint, int dropPoint, int capacity) {
        List<Lift> liftList = new ArrayList<>();
        for (Lift l : DataBase.getInstance().getLiftList()) {
            if (l.isMaintainence()) {
                System.out.println("--> " + l.getLiftName());
                liftList.add(l);
            }
        }
        Map<Integer, Lift> liftMap = new TreeMap<>();
        for (Lift l : liftList) {
            if (liftMap.containsKey(Math.abs(l.getCurrentPos() - pickUpPoint))) {
                if (pickUpPoint - dropPoint < 0) {
                    if (l.getCurrentPos() <= pickUpPoint) {
                        liftMap.put(Math.abs(l.getCurrentPos() - pickUpPoint), l);
                    }
                } else {
                    if (l.getCurrentPos() >= pickUpPoint) {
                        liftMap.put(Math.abs(l.getCurrentPos() - pickUpPoint), l);
                    }
                }
            } else {
                liftMap.put(Math.abs(l.getCurrentPos() - pickUpPoint), l);
            }
        }
        Lift lift = null;
        int diff = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Lift> map : liftMap.entrySet()) {
            System.out.println("Map lift : " + map.getValue().getLiftName());
            if (map.getKey() < diff) {
                lift = map.getValue();
                diff = map.getKey();
            }
        }
        if (lift != null) {
            System.out.println(lift.getLiftName() + " : is Assigned You");
            lift.setCurrentPos(dropPoint);
        } else {
            System.out.println("All the lifts are in Maintenence Please Use Steps");
        }
    }


    public void leastStepLift(int pickUpPoint, int dropPoint, int capacity) {

    }
}
