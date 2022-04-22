package application.dataObjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class foodItemTest {

	
	foodItem foodie = new foodItem(null, null, null, null);
	
	@Test
	void testFoodItem() {
		foodItem foodie = new foodItem(null, null, null, null);
		assertNotNull(foodie);
	}

	@Test
	void testFoodName() {
		foodie.setFoodName("burger");
		assertEquals("burger",foodie.getFoodName());
		assertNotEquals(null,foodie.getFoodName());
	}

	@Test
	void testIngredients() {
		foodie.setIngredients("buns and cheese");
		assertEquals("buns and cheese",foodie.getIngredients());
		assertNotEquals(null,foodie.getIngredients());
	}

	@Test
	void testSetPrice() {
		foodie.setPrice(14.00);
		assertEquals(14.00,foodie.getPrice());
		assertNotEquals(null,foodie.getPrice());
	}

	@Test
	void testUserId() {
		foodie.setUserId(666);
		assertEquals(666,foodie.userId);
		assertEquals(foodie.userId,foodie.getUserId());
		assertNotEquals(null,foodie.userId);
	}

	@Test
	void testMinToCom() {
		foodie.setMinToCom(90);
		assertEquals(90,foodie.minToComplete);
		assertEquals(foodie.minToComplete,foodie.getMinToCom());
		assertNotEquals(null,foodie.minToComplete);
	}



}
