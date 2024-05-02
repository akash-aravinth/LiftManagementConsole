package com.akash.lift.setuplift;

import com.akash.lift.LiftManagement;
import com.akash.lift.database.DataBase;

import java.util.Scanner;
public class SetupLiftView {
    Scanner scanner = new Scanner(System.in);

    private SetupLiftModel setupLiftModel;
    public SetupLiftView(){
        setupLiftModel = new SetupLiftModel(this);
    }

    public void init() {
        System.out.println("Enter No of Lifts You Want : ");
        int noOfLift = scanner.nextInt();
        while (noOfLift-- > 0){
            System.out.println("Enter The Lift Name like --L1,L2---");
            String liftName = scanner.next();
            System.out.println("Enter The Current Position Of the Lift : ");
            int currentPosition = scanner.nextInt();
            System.out.println("Enter the No of capacity in the lift : ");
            int capacity = scanner.nextInt();
            System.out.println("Enter The Lift "+liftName+" stop only the floors");
            System.out.println("Please mention like 1,2,3,4,5 the total floors are only "+ DataBase.getInstance().getNoOfFloors());
            String onlyStop = scanner.next();
            setupLiftModel.createLift(liftName,currentPosition,capacity,onlyStop);
        }
    }
    public void showAlert(String s){
        System.out.println(s);
    }
}
