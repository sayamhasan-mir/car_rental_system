package model;

import java.util.HashMap;
import java.util.Map;

public class Bill {
    private Map<String, Double> items = new HashMap<>();

    public void addItem(String name, double cost) {
        items.put(name, cost);
    }

    public double totalAmount() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        items.forEach((k,v) -> sb.append(k).append(": $").append(v).append("\n"));
        sb.append("Total: $").append(totalAmount());
        return sb.toString();
    }
}
