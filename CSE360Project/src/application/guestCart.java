package application;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class guestCart implements Initializable {
	public guestCart() {
		
	}
	
	private Customer user;
	private Cart newCart;
	private Double totalprice;
	
	@FXML
	private GridPane cartGrid;
	@FXML
	private Button menu;
	@FXML
	private Button checkout;
	@FXML
	private Button logIn;
	@FXML
	private Label totalPrice;
	@FXML
	private Label couponResponse;
	@FXML
	private TextField ccNumText;
	@FXML
	private TextField ccvText;
	@FXML
	private TextField expDateText;
	
Context con = new Context();
	
	NumberFormat cFmt = NumberFormat.getCurrencyInstance();

	public void initializeUser(Customer newUser, Cart cusCart, Double total) {

		user = newUser;
		newCart = cusCart;
		setUserCart();
		totalprice = total;
		
		totalPrice.setText(cFmt.format(totalprice));

	}
	public void menuButton(ActionEvent event) throws IOException{
 		menu();
 	}
 	public void checkoutButton(ActionEvent event) throws IOException{
 		checkout();
 	}
 	
 	public void logInButton(ActionEvent event) throws IOException{
 		logIn();
 	}
 	
	private void checkout() throws IOException{
 		Main m = new Main();
		if(ccNumText.getText().isBlank() || ccvText.getText().isBlank() || expDateText.getText().isBlank()) {
			couponResponse.setTextFill(Color.RED);
			couponResponse.setText("Please fill out payment information");
			
		}
		else {
			
//			newCart.foods.clear();
//			newCart.quantity.clear();
//			newCart.totalPrice = 0.00;
			m.checkoutCustomer(user, newCart);
		}
		
	}
 	
	private void logIn() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
 	}
 	
 	private void setUserCart(){
 		cartGrid.getChildren().clear();
 		if(newCart.foods.size() == 0) {
 			couponResponse.setText("Your cart is empty!");
 	 		cartGrid.getChildren().clear();
 	 		totalprice = 0.0;
 	 		totalPrice.setText(cFmt.format(0.00));

 		}
 		else {
 		
 			for(int jj = 0; jj < newCart.foods.size(); jj++) {
 				Label label = new Label();
 				cartGrid.add(label, 0, jj);
 				label.setText(newCart.foods.get(jj).getFoodName());
 				
 			}
 			for(int jj = 0; jj < newCart.quantity.size(); jj++) {
 				Label label = new Label();
 				cartGrid.add(label, 1, jj);
 				label.setText(newCart.quantity.get(jj).toString());
 				
 			}
 			for(int jj = 0; jj < newCart.quantity.size(); jj++) {
 				Label label = new Label();
 				cartGrid.add(label, 2, jj);
 				Double value = (newCart.foods.get(jj).getPrice()*newCart.quantity.get(jj));
 				label.setText(value.toString());
 				
 			}
 			for(int jj = 0; jj < newCart.quantity.size(); jj++) {
 				final Integer innerMi = jj;
 				Button plus = new Button();
 				cartGrid.add(plus, 3, jj);
 				plus.setMaxWidth(Double.MAX_VALUE);
 				plus.setText("+");
 				plus.setOnAction((event) -> {
 					
 					try {
						addQty(newCart.foods.get(innerMi));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 				});
 				
 			}
 			for(int jj = 0; jj < newCart.quantity.size(); jj++) {
 				final Integer innerMi = jj;
 				Button minus = new Button();
 				cartGrid.add(minus, 4, jj);
 				minus.setMaxWidth(Double.MAX_VALUE);
 				minus.setText("-");
 				minus.setOnAction((event) -> {
 					
 					try {
						subQty(newCart.foods.get(innerMi));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 				});
 				
 				
 			}
 		}
 				
 			
 		
 	}


 	private void menu() throws IOException{
 		Main m = new Main();

 		m.guestMenuScene(user,newCart,totalprice);
 	}
 	
 	private void addQty(foodItem food) throws IOException{	
 		newCart.addFood(food,newCart.quantity.get(newCart.foods.indexOf(food))+1);
	 	totalprice += food.getPrice();
	 	totalPrice.setText(cFmt.format(totalprice));	
 		setUserCart();
 	}
 	private void subQty(foodItem food) throws IOException{
 		if(newCart.quantity.get(newCart.foods.indexOf(food)) == 1){	
 			newCart.quantity.set(newCart.foods.indexOf(food),0);
 			totalprice -= food.getPrice();
 			totalPrice.setText(cFmt.format(totalprice));
 			setUserCart();
 		}
 		else if(newCart.quantity.get(newCart.foods.indexOf(food)) == 0) {
 			
 		}
 		else {
 			
 			newCart.removeFood(food);
 			totalprice -= food.getPrice();
 			totalPrice.setText(cFmt.format(totalprice));
 			setUserCart();
 		}
	
 	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


 	
	
	

}
