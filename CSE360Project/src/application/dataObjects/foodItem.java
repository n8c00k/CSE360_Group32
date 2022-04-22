package application.dataObjects;
import java.text.NumberFormat;

public class foodItem {

    public String foodName;
    public String ingredients;
    public Double price;
    public Integer userId;
    public Integer minToComplete;
    
    NumberFormat cFmt = NumberFormat.getCurrencyInstance();

    public foodItem(String foodName, String ingredients, Double price, Integer minToComplete) {
		this.foodName = foodName;
		this.ingredients = ingredients;
		this.price = price;
		this.minToComplete = minToComplete;

	}
//
//    public void updateFoodItem(){
//    	setFoodName(foodName);
//    	setIngredients(ingredients);
//    	setPrice(price);
//    }

    public void setFoodName(String name){
    	this.foodName = name;
    }

    public void setIngredients(String ing) {
    	this.ingredients = ing;
    }

    public void setPrice(Double amount){
    	this.price = amount;
    }
    
    public void setUserId(Integer x){
    	this.userId = x;
    }

    public void setMinToCom(Integer mins){
    	this.minToComplete = mins;
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
    
    public Integer getMinToCom() {
    	return minToComplete;
    }
    
	@Override
	public String toString() {
		return foodName +  cFmt.format(price) + " ";
	}

}
