package application.dataObjects;

import java.util.ArrayList;

public class Menu {
    
	public static ArrayList<foodItem> foods;
    public String menuName;
    
    public void addFoodItem(foodItem food){
    	foods.add(food);
    }
    public void removeFoodItem(foodItem food){
        foods.remove(food);
    }
    public void editFoodItem(){
        
    }
}
