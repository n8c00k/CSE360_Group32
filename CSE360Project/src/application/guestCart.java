package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.Cart;
import application.dataObjects.Customer;
import application.dataObjects.foodItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class guestCart implements Initializable {
	public guestCart() {
		
	}
	
	private Customer user;
	private Cart newCart;
	private Double totalprice;

	@FXML
	private Text item1;
	@FXML
	private Text item2;
	@FXML
	private Text item3;
	@FXML
	private Text item4;
	@FXML
	private Text item5;
	@FXML
	private Text item6;
	
	@FXML
	private Button menu;
	@FXML
	private Button checkout;
	@FXML
	private Label totalPrice;
	
	@FXML
	private Button gAddItem1;
	@FXML
	private Button gAddItem2;
	@FXML
	private Button gAddItem3;
	@FXML
	private Button gAddItem4;
	@FXML
	private Button gAddItem5;
	
	@FXML
	private Button gRemoveItem1;
	@FXML
	private Button gRemoveItem2;
	@FXML
	private Button gRemoveItem3;
	@FXML
	private Button gRemoveItem4;
	@FXML
	private Button gRemoveItem5;
	
	@FXML
	private Label quantityItem1;
	@FXML
	private Label quantityItem2;
	@FXML
	private Label quantityItem3;
	@FXML
	private Label quantityItem4;
	@FXML
	private Label quantityItem5;
	@FXML
	private Label quantityItem6;

	@FXML
	private Label priceItem1;
	@FXML
	private Label priceItem2;
	@FXML
	private Label priceItem3;
	@FXML
	private Label priceItem4;
	@FXML
	private Label priceItem5;
	@FXML
	private Label priceItem6;
	
	Text[] itemList = new Text[]{item1, item2, item3, item4, item5, item6};
	Label[] qtyList = new Label[] {quantityItem1, quantityItem2, quantityItem3, quantityItem4, quantityItem5, quantityItem6};
	Label[] priceList = new Label[] {priceItem1, priceItem2, priceItem3, priceItem4, priceItem5, priceItem6};
	
	public void initializeUser(Customer newUser, Cart cusCart, Double total) {

		user = newUser;
		newCart = cusCart;
		setUserCart();
		totalprice = total;
		totalPrice.setText("$"+totalprice);

	}
	
	public void menuButton(ActionEvent event) throws IOException{
 		menu();
 	}
	
	private void menu() throws IOException{
 		Main m = new Main();

 		m.menuSceneCustomer(user,newCart,totalprice);
 	}
 	
	
	
 	public void addButton1() throws IOException{
 		addQty(newCart.foods.get(0));
 		quantityItem1.setText(newCart.quantity.get(0).toString());
 		priceItem1.setText(calcPrice(newCart.foods.get(0)));
 		totalPrice.setText("$"+totalprice);
 	}
 	public void addButton2() throws IOException{
 		addQty(newCart.foods.get(1));
 		quantityItem2.setText(newCart.quantity.get(1).toString());
 		priceItem2.setText(calcPrice(newCart.foods.get(1)));
 		totalPrice.setText("$"+totalprice);
 	}
 	public void addButton3() throws IOException{
 		addQty(newCart.foods.get(2));
 		quantityItem3.setText(newCart.quantity.get(2).toString());
 		priceItem3.setText(calcPrice(newCart.foods.get(2)));
 		totalPrice.setText("$"+totalprice);
 	}
 	public void addButton4() throws IOException{
 		addQty(newCart.foods.get(3));
 		quantityItem4.setText(newCart.quantity.get(3).toString());
 		priceItem4.setText(calcPrice(newCart.foods.get(3)));
 		totalPrice.setText("$"+totalprice);
 	}
 	public void addButton5() throws IOException{
 		addQty(newCart.foods.get(4));
 		quantityItem5.setText(newCart.quantity.get(4).toString());
 		priceItem5.setText(calcPrice(newCart.foods.get(4)));
 		totalPrice.setText("$"+totalprice);
 	}
 	
 	public void subButton1() throws IOException{
 		subQty(newCart.foods.get(0));
 		quantityItem1.setText(newCart.quantity.get(0).toString());
 		priceItem1.setText(calcPrice(newCart.foods.get(0)));
 		totalPrice.setText("$"+totalprice);
 	}
 	public void subButton2() throws IOException{
 		subQty(newCart.foods.get(1));
 		quantityItem2.setText(newCart.quantity.get(1).toString());
 		priceItem2.setText(calcPrice(newCart.foods.get(1)));
 		totalPrice.setText("$"+totalprice);
 	}
 	public void subButton3() throws IOException{
 		subQty(newCart.foods.get(2));
 		quantityItem3.setText(newCart.quantity.get(2).toString());
 		priceItem3.setText(calcPrice(newCart.foods.get(2)));
 		totalPrice.setText("$"+totalprice);
 	}
 	public void subButton4() throws IOException{
 		subQty(newCart.foods.get(3));
 		quantityItem4.setText(newCart.quantity.get(3).toString());
 		priceItem4.setText(calcPrice(newCart.foods.get(3)));
 		totalPrice.setText("$"+totalprice);
 	} 	
 	public void subButton5() throws IOException{
 		subQty(newCart.foods.get(4));
 		quantityItem5.setText(newCart.quantity.get(4).toString());
 		priceItem5.setText(calcPrice(newCart.foods.get(4)));
 		totalPrice.setText("$"+totalprice);
 	}
	
	private void setUserCart() {
 		Double price1;
 		Double price2;
 		Double price3;
 		Double price4;
 		Double price5;
 		

		if(newCart.foods.isEmpty()){
		}
		else if(newCart.foods.size() < 2) {
			item1.setText(newCart.foods.get(0).getFoodName());
			quantityItem1.setText(newCart.quantity.get(0).toString());
			price1 = (newCart.foods.get(0).getPrice() * newCart.quantity.get(0));
			priceItem1.setText(String.format("%.2f",price1));
		}
		else if(newCart.foods.size() < 3) {
			item1.setText(newCart.foods.get(0).getFoodName());
			quantityItem1.setText(newCart.quantity.get(0).toString());
			price1 = (newCart.foods.get(0).getPrice() * newCart.quantity.get(0));
			priceItem1.setText(String.format("%.2f",price1));
			
			item2.setText(newCart.foods.get(1).getFoodName());
			quantityItem2.setText(newCart.quantity.get(1).toString());
			price2 = (newCart.foods.get(1).getPrice() * newCart.quantity.get(1));
			priceItem2.setText(String.format("%.2f",price2));
		}
		else if(newCart.foods.size() < 4) {
			item1.setText(newCart.foods.get(0).getFoodName());
			quantityItem1.setText(newCart.quantity.get(0).toString());
			price1 = (newCart.foods.get(0).getPrice() * newCart.quantity.get(0));
			priceItem1.setText(String.format("%.2f",price1.toString()));
			
			item2.setText(newCart.foods.get(1).getFoodName());
			quantityItem2.setText(newCart.quantity.get(1).toString());
			price2 = (newCart.foods.get(1).getPrice() * newCart.quantity.get(1));
			priceItem2.setText(String.format("%.2f",price2));
			
			item3.setText(newCart.foods.get(2).getFoodName());
			quantityItem3.setText(newCart.quantity.get(2).toString());
			price3 = (newCart.foods.get(2).getPrice() * newCart.quantity.get(2));
			priceItem3.setText(String.format("%.2f",price3));
		}
		else if(newCart.foods.size() < 5) {
			item1.setText(newCart.foods.get(0).getFoodName());
			quantityItem1.setText(newCart.quantity.get(0).toString());
			price1 = (newCart.foods.get(0).getPrice() * newCart.quantity.get(0));
			priceItem1.setText(String.format("%.2f",price1));
			
			item2.setText(newCart.foods.get(1).getFoodName());
			quantityItem2.setText(newCart.quantity.get(1).toString());
			price2 = (newCart.foods.get(1).getPrice() * newCart.quantity.get(1));
			priceItem2.setText(String.format("%.2f",price2));
			
			item3.setText(newCart.foods.get(2).getFoodName());
			quantityItem3.setText(newCart.quantity.get(2).toString());
			price3 = (newCart.foods.get(2).getPrice() * newCart.quantity.get(2));
			priceItem3.setText(String.format("%.2f",price3));
			
			item4.setText(newCart.foods.get(3).getFoodName());
			quantityItem4.setText(newCart.quantity.get(3).toString());
			price4 = (newCart.foods.get(3).getPrice() * newCart.quantity.get(3));
			priceItem4.setText(String.format("%.2f",price4));
		}
		else {
				item1.setText(newCart.foods.get(0).getFoodName());
				quantityItem1.setText(newCart.quantity.get(0).toString());
				price1 = (newCart.foods.get(0).getPrice() * newCart.quantity.get(0));
				priceItem1.setText(String.format("%.2f",price1));
				
				item2.setText(newCart.foods.get(1).getFoodName());
				quantityItem2.setText(newCart.quantity.get(1).toString());
				price2 = (newCart.foods.get(1).getPrice() * newCart.quantity.get(1));
				priceItem2.setText(String.format("%.2f",price2));
				
				item3.setText(newCart.foods.get(2).getFoodName());
				quantityItem3.setText(newCart.quantity.get(2).toString());
				price3 = (newCart.foods.get(2).getPrice() * newCart.quantity.get(2));
				priceItem3.setText(String.format("%.2f",price3));
				
				item4.setText(newCart.foods.get(3).getFoodName());
				quantityItem4.setText(newCart.quantity.get(3).toString());
				price4 = (newCart.foods.get(3).getPrice() * newCart.quantity.get(3));
				priceItem4.setText(String.format("%.2f",price4));
				
				item5.setText(newCart.foods.get(4).getFoodName());
				quantityItem5.setText(newCart.quantity.get(4).toString());
				price5 = (newCart.foods.get(4).getPrice() * newCart.quantity.get(4));
				priceItem5.setText(String.format("%.2f",price5));
		}
 	}
	
	private void addQty(foodItem food) throws IOException{	
 		newCart.addFood(food,newCart.quantity.get(newCart.foods.indexOf(food))+1);
	 	totalprice += food.getPrice();
 		totalPrice.setText("$"+totalprice.toString());	
 	}
 	private void subQty(foodItem food) throws IOException{
 		if(newCart.quantity.get(newCart.foods.indexOf(food)) == 1){	
 			newCart.quantity.set(newCart.foods.indexOf(food),0);
 			totalprice -= food.getPrice();
 			totalPrice.setText("$"+totalprice.toString());
 		}
 		else if(newCart.quantity.get(newCart.foods.indexOf(food)) == 0) {
 			
 		}
 		else {
 			
 			newCart.removeFood(food);
 			totalprice -= food.getPrice();
 			totalPrice.setText("$"+totalprice.toString());
 		}
	
 	}
 	
 	private String calcPrice(foodItem food) throws IOException{
 		return String.format("%.2f", food.getPrice() * newCart.quantity.get(newCart.foods.indexOf(food)));
 	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
