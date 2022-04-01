package application.dataObjects;

import java.util.ArrayList;


public class Cart {

	public ArrayList<foodItem> foods;
    public ArrayList<Integer> quantity;
    public Double totalPrice;
    public Integer userId;
    public String receipt;

    public Cart() {
    	foods = new ArrayList<>();
    	quantity = new ArrayList<>();
		totalPrice = 0.0;
		userId = 0;
	}
    public void setUserId(Integer x){
    	this.userId = x;
    }

    public void addFood(foodItem food, Integer qty){
    	this.totalPrice += (food.price * qty);

        if( foods.contains(food)) {
//        	Integer newVal = quantity.get(foods.indexOf(food)) +1;
        	this.quantity.set(foods.indexOf(food), qty);
        }
        else {
        	this.foods.add(food);
        	this.quantity.add(qty);
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

    public String receipt() {
    String food; 
	String quan;
	Double price; 
	String ret = "";
	for(int i = 0; i < foods.size(); i++) {
		 food = foods.get(i).getFoodName();
		 quan = "" + quantity.get(i);
		 price = (double) quantity.get(i) * foods.get(i).getPrice();
		 ret += food + " " + quan + " " + price + "\n";
	}
	ret += totalPrice;
	return ret;
    	
    }
    
    @Override
	public String toString() {
    	
    	return(
    			"Cart Contains: " + foods.toString()+ " Price: "+ totalPrice+
    			" Quantities: " + quantity.toString());
    }
}
