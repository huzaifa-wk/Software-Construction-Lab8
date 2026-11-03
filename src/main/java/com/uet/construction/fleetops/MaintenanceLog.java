/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uet.construction.fleetops;

public class MaintenanceLog {

    private String logId;
    private String serviceDescription;
    private double serviceCost;

    // Parameterized Constructor
    public MaintenanceLog(String logId, String serviceDescription,
            double serviceCost) {

        this.logId = logId;
        this.serviceDescription = serviceDescription;
        this.serviceCost = serviceCost;
    }

    // Copy Constructor
    public MaintenanceLog(MaintenanceLog other) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Maintenance log cannot be null."
            );
        }

        this.logId = other.logId;
        this.serviceDescription = other.serviceDescription;
        this.serviceCost = other.serviceCost;
    }

    // Getters
    public String getLogId() {
        return logId;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    // Setters
    public void setLogId(String logId) {
        this.logId = logId;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        return "MaintenanceLog {"
                + "Log ID='" + logId + '\''
                + ", Description='" + serviceDescription + '\''
                + ", Cost=" + serviceCost
                + '}';
    }
}
   