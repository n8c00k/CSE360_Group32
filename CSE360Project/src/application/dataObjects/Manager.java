package application.dataObjects;

import cse360.Menu;

public class Manager extends User {
    
    

	public Menu menu;
	
	public Manager(Integer userId, String name, String email, String password) {
			super(userId, name, email, password);
			// TODO Auto-generated constructor stub
		}
	
    public void applyCoupon() {
    	//code for adding a coupon object into an existing customer's coupon arraylist
    }
}
