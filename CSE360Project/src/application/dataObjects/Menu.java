package application.dataObjects;

import java.util.ArrayList;

public class Menu {
    
	public ArrayList<foodItem> foods;
    public String menuName;
    
    public Menu(String name) {
    	foods = new ArrayList<foodItem>();
    	menuName = name;
    }
    
    public void addFoodItem(foodItem food){
    	foods.add(food);
    }
    public void removeFoodItem(){
        foods.remove(foods);
    }
    public void editFoodItem(){
        
    }
}
