package model;

public class Equipment {
    private String type;
    private double cost;

    public Equipment(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    // ADD THIS GETTER
    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }
}
