package de.neuefische.shopBasic;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepo {

    private final HashMap<String,Product> allMyProducts;

    public ProductRepo() {
        allMyProducts = new HashMap<>();
        Product product1 = new Product("Banane");
        Product product2 = new Product("Gurke");
        Product product3 = new Product("Wasser");
        allMyProducts.put(product1.getId(), product1);
        allMyProducts.put(product2.getId(), product2);
        allMyProducts.put(product3.getId(), product3);
    }

    public ProductRepo(HashMap<String, Product> allMyProducts) {
        this.allMyProducts = allMyProducts;
    }

    public void add(Product productToAdd){
        allMyProducts.put(productToAdd.getId(),productToAdd);
    }

    public List<Product> list(){
        return allMyProducts.values().stream().toList();
    }

    public Product get(String searchedId){
        Product foundProduct = allMyProducts.get(searchedId);
        if (foundProduct==null){
            throw new RuntimeException("Produkt mit der ID "+searchedId+" nicht gefunden!");
        } else {
            return foundProduct;
        }
    }

    }

