package application.dataObjects;

import java.util.ArrayList;



public class Cart extends Customer {
    
	public ArrayList<foodItem> foods;
    public ArrayList<Integer> quantity;
    public Double totalPrice;
    
    public Cart() {
		super( name, email, password);
		this.foods = new ArrayList<foodItem>();
		this.quantity = new ArrayList<Integer>();
		totalPrice = 0.0;
		
	}
    
    public void addFood(foodItem food){
    	totalPrice += food.price;
    	
        if( foods.contains(food)) {
        	Integer newVal = quantity.get(foods.indexOf(food)) +1;
        	quantity.set(foods.indexOf(food), newVal);
        }
        else {
        	foods.add(food);
        	quantity.add(1);
        }
    }
    public void removeFood(foodItem food){
        
        totalPrice -= food.price;
        if(quantity.get(foods.indexOf(food)) == 1) {
        	quantity.remove(foods.indexOf(food));
        	foods.remove(food);
        }
        else {
        	Integer newVal = quantity.get(foods.indexOf(food)) -1;
        	quantity.set(foods.indexOf(food), newVal);
        }
    }
    public void applyCoupon(){
    	if (!Customer.coupons.isEmpty()){
    		if (totalPrice - 5 <= 0) { 	
            }
    		else {
    			totalPrice = totalPrice -5;
    			Customer.coupons.remove(0);
    		}
        }
    }
    public void verifyCart(){
        
    }
    public String toString() {
    	return("Cart Contains: " + foods.toString()+ " Price: "+ totalPrice+
    			" Quantities: " + quantity.toString());
    }
}
