package application.dataObjects;

import java.util.ArrayList;

public class Customer extends User {

    
	public Cart cart;
    public static ArrayList<Coupon> coupons;
    public static Integer pastOrders;
    public Payment card;
    
    public Customer( String name, String email, String password) {
    	super(name,email,password);
    	pastOrders = 0;
    	coupons = new ArrayList<Coupon>();
    }

    

    public void paymentInfo(){

    }

	@Override
	public String toString() {
		return "Customer Name: " + name + "\nEmail: " + email + 
				"\nPassowrd: " + password + "\nPast Orders: "+ pastOrders;
	}
    
}
