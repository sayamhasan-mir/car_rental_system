package model;

import java.util.Date;

public class VehicleLog {
    private String logId;
    private Vehicle vehicle;
    private String description;
    private Date timestamp;

    public VehicleLog(String logId, Vehicle vehicle, String description) {
        this.logId = logId;
        this.vehicle = vehicle;
        this.description = description;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return timestamp + ": " + description + " for " + vehicle.toString();
    }
}
