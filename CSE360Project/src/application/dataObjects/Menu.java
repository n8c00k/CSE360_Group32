package application.dataObjects;

import java.util.ArrayList;

public class Menu {
    
	public ArrayList<foodItem> foods;
    public String menuName;
    public Integer userId;
    
    public Menu(String name) {
    	foods = new ArrayList<foodItem>();
    	menuName = name;
    	
    }
    
    public void addFoodItem(foodItem food){
    	foods.add(food);
    }
    public void removeFoodItem(foodItem food){
        foods.remove(food);
    }
    
    public Integer getUserId() {
    	return userId;
    }
    public void setUserId(Integer x){
    	this.userId = x;
    }
    
}
