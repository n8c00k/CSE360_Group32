package application.dataObjects;

import java.util.ArrayList;

public class Customer extends User {

    
	public ArrayList<Cart> cart;
    public ArrayList<Coupon> coupons;
    public Integer pastOrders;
    public Payment card;
    
    public Customer( String name, String email, String password) {
    	super( name, email, password);
    	pastOrders = 0;
    	coupons = new ArrayList<Coupon>();
    	cart = new ArrayList<Cart>();
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
    
    public void applyCoupon(){
    	if (!coupons.isEmpty()){
    		if (this.cart.get(0).totalPrice - 5 <= 0) { 	
            }
    		else {
    			this.cart.get(0).totalPrice = cart.get(0).totalPrice - 5;
    			this.coupons.remove(0);
    		}
        }
    }
    
	@Override
	public String toString() {
		return "Customer Name: " + name + "\nEmail: " + email + 
				"\nPassowrd: " + password + "\nPast Orders: "+ pastOrders;
	}
    
}
