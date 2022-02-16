package de.neuefische.shopBasic;

import java.util.HashMap;
import java.util.UUID;

public class Order {

    private final String orderID;
    private final HashMap<String,Product> orderedProducts;

    public Order(HashMap<String, Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
        orderID = UUID.randomUUID().toString();
    }

    public String getOrderID() {
        return orderID;
    }

    public HashMap<String, Product> getOrderedProducts() {
        return orderedProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID='" + orderID + '\'' +
                ", orderedProducts=" + orderedProducts +
                '}';
    }
}
