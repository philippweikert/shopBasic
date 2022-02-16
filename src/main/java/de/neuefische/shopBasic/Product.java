package de.neuefische.shopBasic;

import java.util.UUID;

public class Product {

    private final String name;
    private final String id;

    public Product(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
