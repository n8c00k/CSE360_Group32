
package application.dataObjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CartTest {

	
	Cart cart = new Cart();
	foodItem food = new foodItem("name", "Stuff", 15.98, 12);
	
	@Test
	void testCart() {
		Cart cart = new Cart();
		assertNotNull(cart);
	}

	@Test
	void testUserId() {
		cart.setUserId(12);
		assertEquals(12,cart.getUserId());
		cart.setUserId(null);
		assertEquals(null,cart.getUserId());
	}

	@Test
	void testFood() {
		//add food
		cart.addFood(food, 1);
		assertEquals(food,cart.foods.get(0));
		assertEquals(0,cart.foods.indexOf(food));
		assertEquals(1,cart.foods.size());
		//remove food
		cart.removeFood(food);
		assertEquals(0,cart.foods.size());
		assertNotEquals(food,cart.foods.contains(food));
		
	}



	@Test
	void testReceipt() {
		cart.addFood(food, 2);
		assertEquals("name x 2 $31.96\nTotal Price: $31.96" ,cart.receipt());
	}

	@Test
	void testOrdersAhead() {
		cart.addFood(food, 2);
		assertEquals("24 minutes til pickup ",cart.ordersAhead());
	}



}
