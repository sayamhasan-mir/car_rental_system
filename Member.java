package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private List<VehicleReservation> reservations = new ArrayList<>();

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public void addReservation(VehicleReservation reservation) {
        reservations.add(reservation);
    }

    public List<VehicleReservation> getReservations() { return reservations; }

    public String getName() { return name; }
}
