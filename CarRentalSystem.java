package service;

import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CarRentalSystem {

    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<VehicleLog> logs = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) { vehicles.add(vehicle); }
    public void registerMember(Member member) { members.add(member); }

    public List<Vehicle> searchVehicle(String model) {
        return vehicles.stream()
                .filter(v -> v.getModel().equalsIgnoreCase(model) && v.getStatus().equals("Available"))
                .collect(Collectors.toList());
    }

    public void reserveVehicle(Member member, Vehicle vehicle) {
        if (vehicle.getStatus().equals("Available")) {
            VehicleReservation reservation = new VehicleReservation(
                    "R" + System.currentTimeMillis(), vehicle, member, null, null
            );
            member.addReservation(reservation);
            vehicle.setStatus("Reserved");
            logs.add(new VehicleLog("L" + System.currentTimeMillis(), vehicle, "Vehicle reserved by " + member.getName()));
            System.out.println(member.getName() + " reserved " + vehicle.toString());
        } else {
            System.out.println("Vehicle not available!");
        }
    }

    // Check-out a vehicle
    public void checkoutVehicle(VehicleReservation reservation) {
        Vehicle vehicle = reservation.getVehicle();
        if (vehicle.getStatus().equals("Reserved")) {
            vehicle.setStatus("Rented");
            reservation.setPickupDate(new Date());
            logs.add(new VehicleLog("L" + System.currentTimeMillis(), vehicle, "Vehicle checked out by " + reservation.getMember().getName()));
            System.out.println(reservation.getMember().getName() + " checked out " + vehicle.toString());
        } else {
            System.out.println("Vehicle cannot be checked out!");
        }
    }

    // Return a vehicle
    public void returnVehicle(VehicleReservation reservation) {
        Vehicle vehicle = reservation.getVehicle();
        vehicle.setStatus("Available");
        reservation.setReturnDate(new Date());

        // Calculate late fee if returnDate > due (simplified as 1 day = $50 late)
        if (reservation.getReturnDate().after(reservation.getPickupDate())) {
            long diff = reservation.getReturnDate().getTime() - reservation.getPickupDate().getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            if (days > 0) {
                double lateFee = days * 50; 
                reservation.getBill().addItem("Late Fee", lateFee);
            }
        }

        logs.add(new VehicleLog("L" + System.currentTimeMillis(), vehicle, "Vehicle returned by " + reservation.getMember().getName()));
        System.out.println(reservation.getMember().getName() + " returned " + vehicle.toString());
        System.out.println("Bill Details:\n" + reservation.getBill());
    }

    // Print all vehicle logs
    public void printLogs() {
        System.out.println("=== Vehicle Logs ===");
        logs.forEach(System.out::println);
    }
}
