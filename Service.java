package model;

public class Service {
    private String type;
    private double cost;

    public Service(String type, double cost) {
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
