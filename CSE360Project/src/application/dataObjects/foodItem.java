package application.dataObjects;

import cse360.Menu;

public class foodItem extends Menu{
    
    public String foodName;
    public String ingredients;
    public Double price;
    
    

    public foodItem(String foodName, String ingredients, Double price) {
		super();
		this.foodName = foodName;
		this.ingredients = ingredients;
		this.price = price;
	}
	public void editIngredients(){
        
    }
    public void editPrice(){
        
    }
    public void addToCart(){
        
    }
	@Override
	public String toString() {
		return foodName +  " $" + price + " ";
	}
    
}
