package de.neuefische.shopBasic;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private ProductRepo myProductRepo;
    private OrderRepo myOrderRepo;

    public ShopService(ProductRepo myProductRepo, OrderRepo myOrderRepo) {
        this.myProductRepo = myProductRepo;
        this.myOrderRepo = myOrderRepo;
    }

    public Product getProduct(String whichId){
        return myProductRepo.get(whichId);
    }

    public List<Product> listProducts(){
        return myProductRepo.list();
    }

    public void addOrder(Order orderToAdd){
        myOrderRepo.add(orderToAdd);
    }

    public Optional<Order> getOrder(String whichOrderId){
        return myOrderRepo.get(whichOrderId);
    }

    public List<Order> listOrders(){
        return myOrderRepo.list();
    }

    }


