/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uet.construction.fleetops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FleetDepot {

    private String depotId;
    private String locationName;

    // Stores references to existing Vehicle objects
    private final List<Vehicle> assignedVehicles;

    // Constructor
    public FleetDepot(String depotId, String locationName) {

        setDepotId(depotId);
        setLocationName(locationName);

        assignedVehicles = new ArrayList<>();
    }

    // Getters
    public String getDepotId() {
        return depotId;
    }

    public String getLocationName() {
        return locationName;
    }

    // Setters with Validation
    public void setDepotId(String depotId) {

        if (depotId == null || depotId.isBlank()) {
            throw new IllegalArgumentException(
                    "Depot ID cannot be null or blank."
            );
        }

        this.depotId = depotId;
    }

    public void setLocationName(String locationName) {

        if (locationName == null || locationName.isBlank()) {
            throw new IllegalArgumentException(
                    "Location name cannot be null or blank."
            );
        }

        this.locationName = locationName;
    }

    // Aggregation: Assign an existing Vehicle
    public void assignVehicle(Vehicle vehicle) {

        Objects.requireNonNull(vehicle, "Vehicle cannot be null.");

        if (!assignedVehicles.contains(vehicle)) {
            assignedVehicles.add(vehicle);
        }
    }

    // Release Vehicle without destroying it
    public void releaseVehicle(Vehicle vehicle) {

        Objects.requireNonNull(vehicle, "Vehicle cannot be null.");

        assignedVehicles.remove(vehicle);
    }

    // Return an unmodifiable view
    public List<Vehicle> getAssignedVehicles() {

        return Collections.unmodifiableList(assignedVehicles);
    }

    // Display Depot Information
    @Override
    public String toString() {

        return "FleetDepot {"
                + "Depot ID='" + depotId + '\''
                + ", Location='" + locationName + '\''
                + ", Assigned Vehicles=" + assignedVehicles.size()
                + '}';
    }
}
