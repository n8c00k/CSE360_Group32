package application.dataObjects;


public class Manager extends User {
    
	public Menu menu;
	
	public Manager( Integer userId, String name, String email, String password) {
			super(userId, name, email, password);
			// TODO Auto-generated constructor stub
		}
	
    public void applyCoupon(Customer cust) {
    	
    	Coupon newCoup = new Coupon();
    	Customer.coupons.add(newCoup);
 
    }
}
