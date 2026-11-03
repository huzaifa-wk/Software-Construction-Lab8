/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uet.construction.fleetops;

import java.util.List;

public class FleetVerificationDriver {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" FLEET MANAGEMENT SYSTEM VERIFICATION");
        System.out.println("======================================");

        testAggregationLifecycleIndependence();

        testCompositionEncapsulation();

        System.out.println("\n======================================");
        System.out.println(" ALL VERIFICATION TESTS COMPLETED");
        System.out.println("======================================");
    }

    // ==========================================
    // TEST CASE A: AGGREGATION LIFECYCLE
    // ==========================================
    public static void testAggregationLifecycleIndependence() {

        System.out.println("\nTEST CASE A: AGGREGATION LIFECYCLE");
        System.out.println("--------------------------------------");

        // Step 1: Independently create Drivers
        Driver driver1 = new Driver(
                "D001",
                "Ali Khan",
                "LIC101"
        );

        Driver driver2 = new Driver(
                "D002",
                "Ahmed Shah",
                "LIC102"
        );

        // Step 2: Independently create Vehicles
        Vehicle vehicle1 = new Vehicle(
                "VIN001",
                "Toyota Corolla",
                "ENG001",
                1800,
                "Petrol"
        );

        Vehicle vehicle2 = new Vehicle(
                "VIN002",
                "Honda Civic",
                "ENG002",
                1600,
                "Petrol"
        );

        // Associate drivers with vehicles
        vehicle1.assignDriver(driver1);
        vehicle2.assignDriver(driver2);

        // Step 3: Create Depot
        FleetDepot depot = new FleetDepot(
                "DEP001",
                "Abbottabad Main Depot"
        );

        // Assign existing vehicles
        depot.assignVehicle(vehicle1);
        depot.assignVehicle(vehicle2);

        System.out.println("Vehicles assigned to depot:");
        System.out.println(depot.getAssignedVehicles());

        // Step 4: Nullify depot reference
        depot = null;

        System.out.println("\nDepot reference set to null.");

        // Step 5: Verify independent objects
        System.out.println("\nChecking Vehicle 1:");
        System.out.println(vehicle1);

        System.out.println("\nChecking Vehicle 2:");
        System.out.println(vehicle2);

        System.out.println("\nChecking Driver 1:");
        System.out.println(driver1);

        System.out.println("\nChecking Driver 2:");
        System.out.println(driver2);

        // Assertions
        boolean vehiclesAlive
                = vehicle1 != null && vehicle2 != null;

        boolean driversAlive
                = driver1 != null && driver2 != null;

        boolean driverAssociationsAlive
                = vehicle1.getDriver() == driver1
                && vehicle2.getDriver() == driver2;

        System.out.println("\nAggregation Assertions:");

        System.out.println(
                "Vehicles remain accessible: " + vehiclesAlive
        );

        System.out.println(
                "Drivers remain accessible: " + driversAlive
        );

        System.out.println(
                "Vehicle-Driver references preserved: "
                + driverAssociationsAlive
        );

        System.out.println(
                "TEST CASE A RESULT: "
                + (vehiclesAlive && driversAlive
                && driverAssociationsAlive ? "PASS" : "FAIL")
        );
    }

    // ==========================================
    // TEST CASE B: COMPOSITION & ENCAPSULATION
    // ==========================================
    public static void testCompositionEncapsulation() {

        System.out.println("\nTEST CASE B: COMPOSITION & ENCAPSULATION");
        System.out.println("--------------------------------------");

        // Step 1: Create Vehicle with internal Engine
        Vehicle vehicle = new Vehicle(
                "VIN003",
                "Suzuki Swift",
                "ENG003",
                1200,
                "Petrol"
        );

        // Add maintenance records
        vehicle.addMaintenanceRecord(
                "LOG001",
                "Oil Change",
                2500.0
        );

        vehicle.addMaintenanceRecord(
                "LOG002",
                "Brake Service",
                3500.0
        );

        // Step 2: Retrieve defensive Engine copy
        Engine leakedEngine = vehicle.getEngine();

        // Store original internal engine information
        String originalFuelType
                = vehicle.getEngine().getFuelType();

        System.out.println("\nOriginal Engine:");
        System.out.println(vehicle.getEngine());

        System.out.println(
                "Original Engine Hash Code: "
                + vehicle.getEngine().hashCode()
        );

        System.out.println(
                "Leaked Engine Hash Code: "
                + leakedEngine.hashCode()
        );

        // Step 3: Attempt external mutation
        leakedEngine.setFuelType("Diesel");

        System.out.println("\nModified Leaked Engine:");
        System.out.println(leakedEngine);

        // Step 4: Verify internal engine remains unchanged
        String currentFuelType
                = vehicle.getEngine().getFuelType();

        boolean engineProtected
                = originalFuelType.equals(currentFuelType)
                && !leakedEngine.getFuelType().equals(
                        currentFuelType
                );

        System.out.println("\nEngine Encapsulation Assertion:");

        System.out.println(
                "Internal Engine Fuel Type: " + currentFuelType
        );

        System.out.println(
                "External Engine Fuel Type: "
                + leakedEngine.getFuelType()
        );

        System.out.println(
                "Engine defensive copying works: "
                + engineProtected
        );

        // Step 5: Retrieve maintenance history
        List<MaintenanceLog> leakedHistory
                = vehicle.getMaintenanceHistory();

        int originalHistorySize
                = vehicle.getMaintenanceHistory().size();

        System.out.println("\nOriginal Maintenance History:");
        System.out.println(vehicle.getMaintenanceHistory());

        // Attempt to clear external list
        boolean listProtected = false;

        try {

            leakedHistory.clear();

        } catch (UnsupportedOperationException e) {

            listProtected = true;

            System.out.println(
                    "External list modification prevented."
            );
        }

        // Attempt to mutate a copied maintenance record
        MaintenanceLog leakedLog
                = leakedHistory.get(0);

        leakedLog.setServiceCost(99999.0);

        // Verify internal history
        List<MaintenanceLog> internalHistory
                = vehicle.getMaintenanceHistory();

        boolean recordProtected
                = internalHistory.get(0).getServiceCost()
                != leakedLog.getServiceCost();

        boolean historyIntact
                = internalHistory.size() == originalHistorySize;

        System.out.println("\nMaintenance Encapsulation Assertions:");

        System.out.println(
                "Internal history size: "
                + internalHistory.size()
        );

        System.out.println(
                "External history size: "
                + leakedHistory.size()
        );

        System.out.println(
                "Maintenance list protected: " + listProtected
        );

        System.out.println(
                "Maintenance records protected: "
                + recordProtected
        );

        System.out.println(
                "Internal maintenance history intact: "
                + historyIntact
        );

        // Final Test Result
        boolean testPassed
                = engineProtected
                && listProtected
                && recordProtected
                && historyIntact;

        System.out.println(
                "\nTEST CASE B RESULT: "
                + (testPassed ? "PASS" : "FAIL")
        );
    }
}
