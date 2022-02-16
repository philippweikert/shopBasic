package de.neuefische.shopBasic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/product")
    public List<Product> getProducts(){
        return shopService.listProducts();
    }

    @GetMapping("/order")
    public List<Order> getOrders(){
        return shopService.listOrders();
    }

   /* @PostMapping
    public void createList (@RequestMapping )*/

}
