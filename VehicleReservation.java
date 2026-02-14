package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleReservation {
    private String reservationId;
    private Vehicle vehicle;
    private Member member;
    private Date pickupDate;
    private Date returnDate;
    private List<Equipment> equipment = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private RentalInsurance insurance;
    private Bill bill;

    public VehicleReservation(String reservationId, Vehicle vehicle, Member member, Date pickupDate, Date returnDate) {
        this.reservationId = reservationId;
        this.vehicle = vehicle;
        this.member = member;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.bill = new Bill();
    }

    // Getters and setters
    public Vehicle getVehicle() { return vehicle; }
    public Member getMember() { return member; }
    public Date getPickupDate() { return pickupDate; }
    public void setPickupDate(Date pickupDate) { this.pickupDate = pickupDate; }
    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    public void addEquipment(Equipment e) { equipment.add(e); bill.addItem("Equipment: " + e.getType(), e.getCost()); }
    public void addService(Service s) { services.add(s); bill.addItem("Service: " + s.getType(), s.getCost()); }
    public void setInsurance(RentalInsurance insurance) { this.insurance = insurance; bill.addItem("Insurance: " + insurance.getType(), insurance.getCost()); }
    public Bill getBill() { return bill; }

    @Override
    public String toString() {
        return "Reservation " + reservationId + " for " + vehicle.toString() + " by " + member.getName();
    }
}
