package application.dataObjects;


public class foodItem {
    
    public String foodName;
    public String ingredients;
    public Double price;
    
    public foodItem(String foodName, String ingredients, Double price) {
		this.foodName = foodName;
		this.ingredients = ingredients;
		this.price = price;
	}
    
    public void updateFoodItem(){
    	setFoodName(foodName);
    	setIngredients(ingredients);
    	setPrice(price);
    }
    
    public void setFoodName(String name){
    	this.foodName = name;
    }
    
    public void setIngredients(String ing) {
    	this.ingredients = ing;
    }
    
    public void setPrice(Double amount){
    	this.price = amount;
    }
    
    public String getFoodName() {
    	return foodName;
    }
    
    public String getIngredients() {
    	return ingredients;
    }
    
    public Double getPrice() {
    	return price;
    }
  
	@Override
	public String toString() {
		return foodName +  " $" + price + " ";
	}
    
}
