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
    public void editFoodItem(){
        
    }
//	public void editIngredients(){
//        
//    }
//    public void editPrice(){
//        
//    }

	@Override
	public String toString() {
		return foodName +  " $" + price + " ";
	}
    
}
