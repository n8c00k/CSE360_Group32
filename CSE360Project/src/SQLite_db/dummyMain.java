package SQLite_db;

import java.util.ArrayList;
import application.dataObjects.*;

public class dummyMain {

	public static void main(String[] args) {
		Context data = new Context();
		
		ArrayList<Cart> c = data.getCarts(data.getCustomer("example.com"));
		System.out.println(c.get(0).toString());

	}

}
