package com.akash.lift.database;

import com.akash.lift.model.Lift;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static DataBase dataBase;
    public static DataBase getInstance(){
        if (dataBase == null){
            dataBase = new DataBase();
        }
        return  dataBase;
    }

    private  int noOfFloors ;

    public void setNoOfFloors(int floors){
        noOfFloors = floors;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    List<Lift> liftList = new ArrayList<>();

    public List<Lift> getLiftList() {
        return liftList;
    }

    public void addLift(Lift l){
        liftList.add(l);
    }

    public void printLift(){
        for (Lift l : liftList){
            System.out.println(l.getLiftName());
            System.out.println(l.getCapacity());
            System.out.println(l.getCurrentPos());
            System.out.println(l.isMaintainence());
            for (Integer i : l.getOnlyAllow()){
                System.out.print(i+1 + " ");
            }
            System.out.println("Lift ----");
        }
    }

    public void displayLift(){
        for (Lift l : getLiftList()){
            System.out.println(l.getLiftName()+" --> "+l.getCurrentPos());
        }
    }


}
