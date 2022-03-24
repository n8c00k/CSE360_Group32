package application.dataObjects;


public class Manager extends User {
    
    

	public Menu menu;
	
	public Manager( String name, String email, String password) {
			super(name, email, password);
			// TODO Auto-generated constructor stub
		}
	
    public void applyCoupon() {
    	//code for adding a coupon object into an existing customer's coupon arraylist
    }
}
