package application.dataObjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {
	User sop = new User("Sophia", "sop@gmail.com", "Password");
	
	@Test
	void testUser() {
		User sop = new User("Sophia", "sop@gmail.com", "Password");
		assertNotNull(sop);
	}


	@Test
	void testUserId() {
		sop.setUserId(12);
		assertEquals(12, sop.getUserId());
		sop.setUserId(null);
		assertEquals(null, sop.getUserId());
	}

	@Test
	void testName() {
		assertEquals("Sophia", sop.getName());
		sop.setName("Sofia");
		assertEquals("Sofia", sop.getName());
		sop.setName(null);
		assertEquals(null, sop.getName());
	}

	@Test
	void testEmail() {
		assertEquals("sop@gmail.com", sop.getEmail());
		sop.setEmail("sop123@gmail.com");
		assertEquals("sop123@gmail.com", sop.getEmail());
		sop.setEmail(null);
		assertEquals(null, sop.getEmail());
	}

	@Test
	void testPassword() {
		//Password is case sensitive
		assertNotEquals("password", sop.getPassword());
		assertEquals("Password", sop.getPassword());
		
		sop.setPassword("password123");
		assertEquals("password123", sop.getPassword());
		sop.setPassword(null);
		assertEquals(null, sop.getPassword());
	}

}
