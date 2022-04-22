package SQLite_db;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import application.dataObjects.*;


/*
 * Unit Testing for Context.java
 * ASSUMPTIONS:
 * 		Data object work as planed
 */
class ContextTest {
	
	static Context database;
	
	/*
	 * Test #0
	 * Testing function:
	 * 		Context
	 */
	@BeforeAll
	@Test
	static void testContext() {
		database = new Context();
		assertNotNull(database, "Database not opened");
	}
	
	/*
	 * Test #1
	 * Testing functions:
	 * 		setUser
	 * 		getUser
	 */
	@Test
	void testUser() {
		//Testing on good data
		User u = new User("TestU","TestU@email.com","1");
		database.setUser(u);
		User x = database.getUser("TestU@email.com", "1");
		//assert that all aspects of user are equal. I would use the the toString but this class dose not have it
		assertEquals(u.getEmail(),x.getEmail(),u.getEmail()+"!="+x.getEmail());
		assertEquals(u.getName(),x.getName(),u.getName()+"!="+x.getName());
		assertEquals(u.getPassword(),x.getPassword(),u.getPassword()+"!="+x.getPassword());
		assertEquals(u.getUserId(),x.getUserId(),u.getUserId()+"=="+x.getUserId());//I don't know what the database will give x for ID but it shouldn't be null
		
		//bad data
		User u2 = new User("TestU2\';","TestU2@email.com","1");//this is SQL injection it will error when set to DB
		database.setUser(u2);
		User x2 = database.getUser("TestU2@email.com", "1");//this user should not exist
		//assert x2 is nothing
		assertNull(x2);
		
		//Null data
		User u3 = new User("","","");//email is a unique constant it must be present 
		database.setUser(u3);//so this should fail
		User x3 = database.getUser("", "");//and this should get nothing
		//assert x3 is nothing
		assertNull(x3);
	}
	
	/*
	 * Test #2
	 * Testing functions:
	 * 		setCustomer
	 * 		setPaymentInfo
	 * 		getCustomer(email,pass)
	 * 		getPaymentInfo
	 */
	@Test
	void testSetCustomer() {
		//good data
		Customer c = new Customer("TestU2","TestU2@email.com","12");//set main data
		//set payment card
		Payment p = new Payment(9876,543,12);
		c.setCard(p);
		//set to database
		database.setCustomer(c);
		Customer x = database.getCustomer("TestU2@email.com", "12");
		//make assertions
		assertEquals(c.toString(),x.toString());
		assertEquals(c.getCard().toString(),x.getCard().toString());
		
		//Bad data
		Customer c1 = new Customer("TestU2b\';","TestU2b@email.com","12b");//set bad data
		//set payment card
		Payment p1 = new Payment(-9876,543,12);//set bad data
		c1.setCard(p1);
		//set to database
		database.setCustomer(c1);
		Customer x1 = database.getCustomer("TestU2b@email.com", "12b");//this customer should not exist
		//make assertions
		assertNull(x1);
		
		//Bad data
		Customer c2 = new Customer("","","");//set no data
		//set payment card
		Payment p2 = new Payment(null,null,null);//set no data
		c2.setCard(p2);
		//set to database
		database.setCustomer(c2);
		Customer x2 = database.getCustomer("", "");//this customer should not exist
		//make assertions
		assertNull(x2);
	}
	
	/*
	 * Test #3
	 * Testing functions:
	 * 		getCustomer(email)
	 * 		getPaymentInfo
	 * 		getCarts
	 * 		getCoupons
	 */
	@Test
	void testGetCustomer() {
		//good data
		Customer c = database.getCustomer("example.com");
		assertEquals("john doer", c.getName());
		assertEquals("example.com", c.getEmail());
		assertEquals("1234", c.getPassword());
		assertEquals(1,c.getPastOrders());
		assertEquals("Card Number: 123456\nCCV: 111\nExpiration Date: 1221", c.getCard().toString());
		//this user only has one cart
		assertEquals("Cart Contains: [Belgian Waffles$10.99 , Strawberry Banana Pancakes$15.49 , Chocolate Chip Pancakes$11.79 , Strawberries & Cream Crepes$10.69 , French Toast$8.59 ] Price: $904.86 Quantities: [2, 5, 7, 7, 5]\r\n"
				, c.getCartIndex(0).toString());
		
		//bad data
		Customer c1 = database.getCustomer("alsojmclasdcladsnca");//this user dose not exist
		assertNull(c1);
		
		//bad data
		Customer c2 = database.getCustomer("");//this user dose not exist
		assertNull(c2);
	}

	@Test
	void testManager() {
		fail("Not yet implemented");
	}

	@Test
	void testFoodItem() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCart() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCoupon() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveCoupon() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMenu() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCoupons() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCarts() {
		fail("Not yet implemented");
	}

}
