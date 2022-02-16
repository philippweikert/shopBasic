package de.neuefische.shopBasic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecondtryApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void shouldFindProductByID(){
		//GIVEN
		Product myFirstProduct = new Product("Kartoffeln");
		Product mySecondProduct  = new Product("Bier");
		ProductRepo myProductRepo  = new ProductRepo();
		myProductRepo.add(myFirstProduct);
		myProductRepo.add(mySecondProduct);
		OrderRepo myOrderRepo = new OrderRepo();
		ShopService myTestShop = new ShopService(myProductRepo,myOrderRepo);
		//WHEN
		Product actual = myTestShop.getProduct(myFirstProduct.getId());
		//THEN
		assertEquals(myFirstProduct,actual);
	}

	@Test
	void shouldThrowWithNonexistingID(){
		//GIVEN
		Product myFirstProduct = new Product("Kartoffeln");
		Product mySecondProduct  = new Product("Bier");
		ProductRepo myProductRepo  = new ProductRepo();
		myProductRepo.add(myFirstProduct);
		myProductRepo.add(mySecondProduct);
		OrderRepo myOrderRepo = new OrderRepo();
		ShopService myTestShop = new ShopService(myProductRepo,myOrderRepo);
		//WHEN
		try{
			Product actual = myTestShop.getProduct("kjadshfhk");
			fail();
		} catch (Exception e){
			//THEN
			assertEquals("Produkt mit der ID kjadshfhk nicht gefunden!", e.getMessage());
		}
	}

	@Test
	void shouldListAllProducts(){
		//GIVEN
		Product myFirstProduct = new Product("Kartoffeln");
		Product mySecondProduct  = new Product("Bier");
		List<Product> expected = List.of(myFirstProduct,mySecondProduct);
		ProductRepo myProductRepo  = new ProductRepo();
		myProductRepo.add(myFirstProduct);
		myProductRepo.add(mySecondProduct);
		OrderRepo myOrderRepo = new OrderRepo();
		ShopService myTestShop = new ShopService(myProductRepo,myOrderRepo);
		//WHEN
		List<Product> actual = myTestShop.listProducts();
		//THEN
		assertTrue(actual.containsAll(expected));
	}

	@Test
	void shouldAddNewOrderToOrderRepo(){
		//GIVEN
		Product myFirstProduct = new Product("Kartoffeln");
		Product mySecondProduct  = new Product("Bier");
		HashMap<String, Product> shoppingCart = new HashMap<>();
		shoppingCart.put(myFirstProduct.getId(),myFirstProduct);
		ProductRepo myProductRepo  = new ProductRepo();
		myProductRepo.add(myFirstProduct);
		myProductRepo.add(mySecondProduct);
		OrderRepo myOrderRepo = new OrderRepo();
		Order myTestOrder = new Order(shoppingCart);

		ShopService myTestShop = new ShopService(myProductRepo,myOrderRepo);

		//WHEN
		myTestShop.addOrder(myTestOrder);
		//THEN
		assertEquals(myTestOrder, myTestShop.getOrder(myTestOrder.getOrderID()).get());

	}

	@Test
	void shouldBeOptionalEmpty(){
		//GIVEN
		Product myFirstProduct = new Product("Kartoffeln");
		Product mySecondProduct  = new Product("Bier");
		HashMap<String, Product> shoppingCart = new HashMap<>();
		shoppingCart.put(myFirstProduct.getId(),myFirstProduct);
		ProductRepo myProductRepo  = new ProductRepo();
		myProductRepo.add(myFirstProduct);
		myProductRepo.add(mySecondProduct);
		OrderRepo myOrderRepo = new OrderRepo();
		Order myTestOrder = new Order(shoppingCart);

		ShopService myTestShop = new ShopService(myProductRepo,myOrderRepo);

		//WHEN
		Optional<Order> myOptOrder = myTestShop.getOrder("gibts nich");
		//THEN
		assertTrue(myOptOrder.isEmpty());
	}

	@Test
	void shouldListAllOrders(){
		//GIVEN
		Product myFirstProduct = new Product("Kartoffeln");
		Product mySecondProduct  = new Product("Bier");
		HashMap<String, Product> shoppingCart = new HashMap<>();
		shoppingCart.put(myFirstProduct.getId(),myFirstProduct);
		ProductRepo myProductRepo  = new ProductRepo();
		myProductRepo.add(myFirstProduct);
		myProductRepo.add(mySecondProduct);
		OrderRepo myOrderRepo = new OrderRepo();
		Order myTestOrder = new Order(shoppingCart);
		ShopService myTestShop = new ShopService(myProductRepo,myOrderRepo);
		myTestShop.addOrder(myTestOrder);

		//WHEN
		List<Order> actual = myTestShop.listOrders();
		//THEN
		assertTrue(actual.contains(myTestOrder));
	}

}
