package application.dataObjects;

import java.util.ArrayList;

public class Customer extends User {

    
	public ArrayList<Cart> cart;
    public ArrayList<Coupon> coupons;
    public Integer pastOrders;
    public Payment card;
    
    public Customer( String name, String email, String password) {
    	super(name,email,password);
    	pastOrders = 0;
    	coupons = new ArrayList<Coupon>();
    }
    
    public void setCart(ArrayList<Cart> cart) {
    	  this.cart = cart;
    	}
    
    public ArrayList<Cart> getCart() {
        return cart;
    }
    
    public Cart getCartIndex(int i) {
    	return cart.get(i);
    }

    public void setCoupon(ArrayList<Coupon> coupon) {
  	  this.coupons = coupon;
  	}
    
    public ArrayList<Coupon> getCoupon() {
        return coupons;
    }

    public Coupon getCouponIndex(int i) {
    	return coupons.get(i);
    }
    
    public void setPastOrders(Integer orders){
    	this.pastOrders = orders;
    }
    
    public Integer getPastOrders() {
    	return pastOrders;
    }
    
    public void setCard(Payment newCard) {
    	this.card = newCard;
    }
    
    public Payment getCard() {
    	return card;
    }
    
    //Do we need this method anymore?
    ///public void paymentInfo(){

   /// }

	@Override
	public String toString() {
		return "Customer Name: " + name + "\nEmail: " + email + 
				"\nPassowrd: " + password + "\nPast Orders: "+ pastOrders;
	}
    
}
