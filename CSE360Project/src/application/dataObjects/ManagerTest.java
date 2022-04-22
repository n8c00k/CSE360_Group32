package application.dataObjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagerTest {
	Manager x = new Manager("Boss", "boss@gmail.com", "pass123");
	Customer y = new Customer(null, null, null);
	Coupon z = new Coupon();

	@Test
	void testManager() {
		Manager x = new Manager("Boss", "boss@gmail.com", "pass123");
		assertNotNull(x);
	}

	@Test
	void testApplyCoupon() {
		assertEquals(0, y.coupons.size());
		x.applyCoupon(y);
		assertEquals(1, y.coupons.size());
	}

}
