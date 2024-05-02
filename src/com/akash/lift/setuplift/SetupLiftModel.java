package com.akash.lift.setuplift;

import com.akash.lift.database.DataBase;
import com.akash.lift.model.Lift;

import java.util.ArrayList;
import java.util.List;

public class SetupLiftModel {
    private SetupLiftView setupLiftView;
    public SetupLiftModel(SetupLiftView setupLiftView){
        this.setupLiftView = setupLiftView;
    }

    public void createLift(String liftName, int currentPosition, int capacity, String onlyStop) {
        Lift lift = new Lift();
        lift.setLiftName(liftName);
        lift.setCapacity(capacity);
        lift.setMaintainence(true);
        lift.setCurrentPos(currentPosition);
        String arr[] = onlyStop.split(",");
        List<Integer> li = new ArrayList<>();
        for (String s : arr){
            li.add(Integer.parseInt(s));
        }
        lift.setOnlyAllow(li);
        DataBase.getInstance().addLift(lift);
        setupLiftView.showAlert("Lift Added Successfully\n");
    }
}
