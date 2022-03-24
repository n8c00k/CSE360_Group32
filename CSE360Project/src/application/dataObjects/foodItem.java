package application.dataObjects;


public class foodItem {
    
    public String foodName;
    public String ingredients;
    public Double price;
    public Integer userId;
    
    public foodItem(String foodName, String ingredients, Double price, Integer userId) {
		this.foodName = foodName;
		this.ingredients = ingredients;
		this.price = price;
		this.userId = userId;
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
    
    public Integer getUserId() {
    	return userId;
    }
  
	@Override
	public String toString() {
		return foodName +  " $" + price + " ";
	}
    
}
