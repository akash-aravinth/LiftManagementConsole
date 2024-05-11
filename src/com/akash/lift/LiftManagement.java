package com.akash.lift;

import com.akash.lift.database.DataBase;
import com.akash.lift.setuplift.SetupLiftView;
import com.akash.lift.startapp.StartAppView;

import java.util.Scanner;

public class LiftManagement {
    Scanner scanner = new Scanner(System.in);
    private static LiftManagement liftManagement;

    public static LiftManagement getInstance() {
        if (liftManagement == null) {
            liftManagement = new LiftManagement();
        }
        return liftManagement;
    }

    private String appName = "Lift Management";
    private String appVersion = "1.0.0";

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void createLift() {
        SetupLiftView setupLiftView = new SetupLiftView();
        setupLiftView.init();
    }

    public void init() {
        System.out.println("Welcome To " + getAppName());
        System.out.println("And the version is : " + getAppVersion());
        System.out.println("Enter No of Floors You Have : ");
        int floor = scanner.nextInt();
        DataBase.getInstance().setNoOfFloors(floor);
        createLift();
        startApp();
    }

    private void startApp() {
        StartAppView startAppView = new StartAppView();
        startAppView.init();
    }

    public static void main(String[] args) {
        LiftManagement.getInstance().init();
    }

}
