package application.dataObjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CouponTest {

	
	Coupon coupon = new Coupon();
	
	@Test
	void testCoupon() {
		Coupon coupon = new Coupon();
		assertNotNull(coupon, "whatever");
	}

	@Test
	void testUserId() {
		coupon.setUserId(12);
		assertEquals(12,coupon.getUserId());
		assertNotEquals(null,coupon.userId);
		coupon.setUserId(null);
		assertEquals(null,coupon.getUserId());
	}
	
	@Test
	void testId() {
		coupon.setId(98);
		assertEquals(98,coupon.getId());
		assertNotEquals(null,coupon.Id);
		coupon.setId(null);
		assertEquals(null,coupon.getId());
	}


}
