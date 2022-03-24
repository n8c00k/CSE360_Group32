package application.dataObjects;

public class Menu {
    
    public foodItem[] foods;
    public String menuName;
    
    public void addFoodItem(foodItem food){
    	foods[foods.length] = food;
    }
    public void removeFoodItem(){
        
    }
    public void editFoodItem(){
        
    }
}
