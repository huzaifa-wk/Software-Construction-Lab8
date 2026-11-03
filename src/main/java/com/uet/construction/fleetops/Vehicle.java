/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uet.construction.fleetops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vehicle {

    private String vin;
    private String model;

    // Composition: Vehicle owns its Engine
    private final Engine engine;

    // Composition: Vehicle owns its MaintenanceLog entries
    private final List<MaintenanceLog> maintenanceHistory;

    // Aggregation: Driver exists independently
    private Driver driver;

    // Constructor: Accepts raw Engine parameters
    public Vehicle(String vin, String model,
            String engineNumber,
            int displacementCC,
            String fuelType) {

        this.vin = vin;
        this.model = model;

        // Engine is created internally
        this.engine = new Engine(
                engineNumber,
                displacementCC,
                fuelType
        );

        this.maintenanceHistory = new ArrayList<>();

        this.driver = null;
    }

    // Getters for basic attributes
    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }

    // Defensive Engine Accessor
    public Engine getEngine() {

        return new Engine(this.engine);
    }

    // Add Maintenance Record Internally
    public void addMaintenanceRecord(String logId,
            String description,
            double cost) {

        MaintenanceLog record = new MaintenanceLog(
                logId,
                description,
                cost
        );

        maintenanceHistory.add(record);
    }

    // Defensive Maintenance History Accessor
    public List<MaintenanceLog> getMaintenanceHistory() {

        List<MaintenanceLog> copiedHistory = new ArrayList<>();

        for (MaintenanceLog record : maintenanceHistory) {

            copiedHistory.add(new MaintenanceLog(record));
        }

        return Collections.unmodifiableList(copiedHistory);
    }

    // Aggregation: Assign an existing Driver
    public void assignDriver(Driver driver) {

        this.driver = driver;
    }

    // Release Driver without destroying it
    public void releaseDriver() {

        this.driver = null;
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {

        return "Vehicle {"
                + "VIN='" + vin + '\''
                + ", Model='" + model + '\''
                + ", Engine=" + engine
                + ", Maintenance Records="
                + maintenanceHistory.size()
                + ", Driver=" + driver
                + '}';
    }
}
