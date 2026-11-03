/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.uet.construction.fleetops;

public class Lab08_ObjectRelationships_Student {

    public static void main(String[] args) {

        // Create Vehicle
        Vehicle vehicle = new Vehicle(
                "VIN101",
                "Toyota Corolla",
                "ENG101",
                1800,
                "Petrol"
        );

        // Add maintenance records
        vehicle.addMaintenanceRecord(
                "LOG001", "Oil Change", 5000.0
        );

        vehicle.addMaintenanceRecord(
                "LOG002", "Brake Inspection", 3000.0
        );

        System.out.println("Original Vehicle:");
        System.out.println(vehicle);

        // Test Engine Defensive Copying
        Engine copiedEngine = vehicle.getEngine();

        copiedEngine.setFuelType("Diesel");

        System.out.println("\nOriginal Engine:");
        System.out.println(vehicle.getEngine());

        System.out.println("\nModified Copy:");
        System.out.println(copiedEngine);

        // Test Maintenance Defensive Copying
        MaintenanceLog copiedLog
                = vehicle.getMaintenanceHistory().get(0);

        copiedLog.setServiceCost(99999.0);

        System.out.println("\nOriginal Maintenance History:");

        for (MaintenanceLog log
                : vehicle.getMaintenanceHistory()) {

            System.out.println(log);
        }

        // Test Unmodifiable List
        try {
            vehicle.getMaintenanceHistory().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println(
                    "\nSuccess: External list modification prevented!"
            );
        }
    }
}
