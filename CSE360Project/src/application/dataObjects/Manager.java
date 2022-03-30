package application.dataObjects;

import java.util.ArrayList;

public class Manager extends User {

	public Menu menu;
	public ArrayList<Cart> ordersInProg;

	public Manager( String name, String email, String password) {
			super( name, email, password);
			ordersInProg = new ArrayList<>();
		}
	
	

    public void applyCoupon(Customer cust) {

    	Coupon newCoup = new Coupon();
    	cust.coupons.add(newCoup);

    }
}
