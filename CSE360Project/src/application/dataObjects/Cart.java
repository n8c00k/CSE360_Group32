package application.dataObjects;

import java.util.ArrayList;


public class Cart {

	public ArrayList<foodItem> foods;
    public ArrayList<Integer> quantity;
    public Double totalPrice;
    public Integer userId;

    public Cart() {
    	foods = new ArrayList<>();
    	quantity = new ArrayList<>();
		totalPrice = 0.0;
		userId = 0;
	}
    public void setUserId(Integer x){
    	this.userId = x;
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

    public Integer getUserId() {
    	return userId;
    }

    @Override
	public String toString() {
    	return("Cart Contains: " + foods.toString()+ " Price: "+ totalPrice+
    			" Quantities: " + quantity.toString());
    }
}
