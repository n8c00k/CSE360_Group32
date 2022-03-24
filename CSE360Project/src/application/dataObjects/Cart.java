package application.dataObjects;

import java.util.ArrayList;

import cse360.foodItem;

public class Cart extends Customer {
    
	public ArrayList<foodItem> foods = new ArrayList<foodItem>();
	//public foodItem foods[];
    //public Integer[] quantity;
    public ArrayList<Integer> quantity = new ArrayList<Integer>();
    public Double totalPrice;
    
    public Cart() {
		super( name, email, password);
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
