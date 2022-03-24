package application.dataObjects;


public class Manager extends User {
    
    

	public Menu menu;
	
	public Manager( String name, String email, String password) {
			super(name, email, password);
			// TODO Auto-generated constructor stub
		}
	
    public void applyCoupon(Customer cust) {
    	
    	Coupon newCoup = new Coupon();
    	Customer.coupons.add(newCoup);
 
    }
}
