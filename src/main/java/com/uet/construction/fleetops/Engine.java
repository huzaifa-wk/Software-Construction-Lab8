/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uet.construction.fleetops;

public class Engine {

    private String engineNumber;
    private int displacementCC;
    private String fuelType;

    // Parameterized Constructor
    public Engine(String engineNumber, int displacementCC, String fuelType) {
        this.engineNumber = engineNumber;
        this.displacementCC = displacementCC;
        this.fuelType = fuelType;
    }

    // Copy Constructor
    public Engine(Engine other) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Engine cannot be null."
            );
        }

        this.engineNumber = other.engineNumber;
        this.displacementCC = other.displacementCC;
        this.fuelType = other.fuelType;
    }

    // Getters
    public String getEngineNumber() {
        return engineNumber;
    }

    public int getDisplacementCC() {
        return displacementCC;
    }

    public String getFuelType() {
        return fuelType;
    }

    // Setters
    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public void setDisplacementCC(int displacementCC) {
        this.displacementCC = displacementCC;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Engine {"
                + "Engine Number='" + engineNumber + '\''
                + ", Displacement=" + displacementCC + " CC"
                + ", Fuel Type='" + fuelType + '\''
                + '}';
    }
}
