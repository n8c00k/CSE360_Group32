package application.dataObjects;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CustomerTest {
	
	Customer cus = new Customer("johnny","email.com","123");
	Payment pay = new Payment(666,89,1997); 
	ArrayList<Cart> cusCart = new ArrayList<Cart>();
	
	@Test
	void testCustomer() {
		Customer cus = new Customer("johnny","email.com","123");
		assertNotNull(cus);
	}

	@Test
	void testCart() {
		assertEquals(cus.cart,cus.getCart());
		cus.setCart(cusCart);
		assertEquals(cusCart,cus.getCart());
	}

	@Test
	void testGetCartIndex() {
		Cart foodCart = new Cart();
		cusCart.add(foodCart);
		assertEquals(foodCart,cusCart.get(0));
		assertEquals(0,cusCart.indexOf(foodCart));
	}

	@Test
	void testCoupon() {
		Coupon testCoupon = new Coupon();
		cus.coupons.add(testCoupon);
		assertEquals(testCoupon,cus.coupons.get(0));
		assertEquals(0,cus.coupons.indexOf(testCoupon));
	}


	@Test
	void testPastOrders() {
		cus.setPastOrders(4);
		assertEquals(4,cus.getPastOrders());
		assertEquals(4,cus.pastOrders);
	}


	@Test
	void testSetCard() {
		cus.setCard(pay);
		assertEquals(pay,cus.card);
		assertEquals(pay,cus.getCard());
	}



	@Test
	void testQuantityOfCoupons() {
		assertEquals(0,cus.coupons.size());
		cus.coupons.add(null);
		assertEquals(1,cus.coupons.size());
		cus.coupons.clear();
		assertEquals(0,cus.coupons.size());
	}


}
