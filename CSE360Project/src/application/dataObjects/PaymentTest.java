package application.dataObjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentTest {
	
	Payment pay = new Payment(11111111, 123, 0210);
	
	@Test
	void testPayment() {
		Payment pay = new Payment(11111111, 123, 0210);
		assertNotNull(pay);
	}

	@Test
	void testCardNumber() {
		//testing get
		assertEquals(11111111, pay.getCardNumber());
		//testing set
		pay.setCardNumber(22222222);
		assertEquals(22222222, pay.getCardNumber());
		pay.setCardNumber(null);
		assertEquals(null, pay.getCardNumber());
	}

	@Test
	void testCcv() {
		assertEquals(123, pay.getCcv());
		pay.setCcv(333);
		assertEquals(333, pay.getCcv());
		pay.setCcv(null);
		assertEquals(null, pay.getCcv());
	}

	@Test
	void testExpDate() {
		assertEquals(0210, pay.getExpDate());
		pay.setExpDate(0310);
		assertEquals(0310, pay.getExpDate());
		//formatting could be added in the future, but it wont throw error as of now 
		pay.setExpDate(04/23);
		assertEquals(04/23, pay.getExpDate());
	}

}
