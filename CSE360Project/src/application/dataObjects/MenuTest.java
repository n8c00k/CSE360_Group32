package application.dataObjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuTest {
	Menu x = new Menu("breakfast");
	User sop = new User("Sophia", "sop@gmail.com", "Password");
	foodItem y = new foodItem(null, null, null, null);
	
	
	@Test
	void testMenu() {
		Menu x = new Menu("breakfast");
		assertNotNull(x);
	}

	@Test
	void testFoodItem() {
		x.addFoodItem(y);
		assertEquals(y, x.foods.get(0));
		assertEquals(0,x.foods.indexOf(y));
		assertEquals(1, x.foods.size());
		x.removeFoodItem(y);
		assertEquals(0,x.foods.size());
		assertNotEquals(y,x.foods.contains(y));
	}


	void testUserId() {
		sop.setUserId(12);
		assertEquals(12, sop.getUserId());
		sop.setUserId(null);
		assertEquals(null, sop.getUserId());
	}

}
