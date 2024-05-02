package com.akash.lift.startapp;

import com.akash.lift.LiftManagement;
import com.akash.lift.database.DataBase;
import com.akash.lift.setuplift.SetupLiftView;

import java.util.Scanner;

public class StartAppView {
    Scanner scanner = new Scanner(System.in);
    private StartAppModel startAppModel;
    public StartAppView(){
        startAppModel = new StartAppModel(this);
    }

    public void init(){
        System.out.println("1 --> Take a Lift\n" +
                "2 --> Print Lift Details\n" +
                "3 --> Assign a Lift to Maintainence\n" +
                "4 --> Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 : {
                takeLift();
                init();
                break;
            }
            case 2 : {
                DataBase.getInstance().displayLift();
                init();
                break;
            }
            case 3 : {
                assignMaintanence();
                init();
                break;
            }
            case 4 : {
                System.out.println("Thank You for Using : "+ LiftManagement.getInstance().getAppName()+"\n" +
                        "and the Version is : "+LiftManagement.getInstance().getAppVersion());
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Please Enter a Valid Choice");
                init();
                break;
            }
        }

    }

    private void assignMaintanence() {
        System.out.println("Enter the lift name You wants to assign maintanence");
        String liftName = scanner.next();
        startAppModel.setMaintanece(liftName);
    }

    private void takeLift() {
        System.out.println("Enter The Floor You are ");
        int pickUpPoint = scanner.nextInt();
        System.out.println("Enter The Floor You want's to go");
        int dropPoint = scanner.nextInt();
        System.out.println("Enter No of People in Your Floor");
        int capacity = scanner.nextInt();
        startAppModel.assignLift(pickUpPoint,dropPoint,capacity);
    }

    public void showAlert(String s) {
        System.out.println(s);
    }
}
