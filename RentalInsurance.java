package model;

public class RentalInsurance {
    private String type;
    private double cost;

    public RentalInsurance(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }
}
