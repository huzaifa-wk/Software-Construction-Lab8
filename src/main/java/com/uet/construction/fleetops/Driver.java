/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uet.construction.fleetops;

public class Driver {

    private String driverId;
    private String fullName;
    private String licenseNumber;

    // Parameterized Constructor
    public Driver(String driverId, String fullName, String licenseNumber) {

        setDriverId(driverId);
        setFullName(fullName);
        setLicenseNumber(licenseNumber);
    }

    // Getters
    public String getDriverId() {
        return driverId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    // Setters with Validation
    public void setDriverId(String driverId) {
        if (driverId == null || driverId.isBlank()) {
            throw new IllegalArgumentException(
                    "Driver ID cannot be null or blank."
            );
        }
        this.driverId = driverId;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException(
                    "Full name cannot be null or blank."
            );
        }
        this.fullName = fullName;
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "License number cannot be null or blank."
            );
        }
        this.licenseNumber = licenseNumber;
    }

    // toString Method
    @Override
    public String toString() {
        return "Driver Profile {"
                + "Driver ID='" + driverId + '\''
                + ", Full Name='" + fullName + '\''
                + ", License Number='" + licenseNumber + '\''
                + '}';
    }
}
