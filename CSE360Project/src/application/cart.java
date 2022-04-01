package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.Cart;
import application.dataObjects.Customer;
import application.dataObjects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class cart implements Initializable{
	public cart() {

	}
	private Customer user;
	private Cart newCart;

	@FXML
	private Button menu;

	@FXML
	private Button account;

	@FXML
	private Button logout;

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
	private Button addItem1;

	@FXML
	private Button removeItem1;

	@FXML
	private Button addItem2;

	@FXML
	private Button removeItem2;

	@FXML
	private Button addItem3;

	@FXML
	private Button removeItem3;

	@FXML
	private Label quantityItem1;

	@FXML
	private Label priceItem1;

	@FXML
	private Label quantityItem2;

	@FXML
	private Label priceItem2;

	@FXML
	private Label quantityItem3;

	@FXML
	private Label priceItem3;
	@FXML
	private Label quantityItem4;

	@FXML
	private Label priceItem4;
	@FXML
	private Label quantityItem5;

	@FXML
	private Label priceItem5;
	@FXML
	private Label quantityItem6;

	@FXML
	private Label priceItem6;


	@FXML
	private Label totalPrice;

	@FXML
	private Button checkout;
	@FXML
	private Button applyCoupon;
	@FXML
	private Label couponResponse;

	Context con = new Context();


	public void initializeUser(Customer newUser, Cart cusCart) {

		user = newUser;
		newCart = cusCart;
		
		if(newCart.foods.isEmpty()){
		}
		else if(newCart.foods.size() < 2) {
			item1.setText(newCart.foods.get(0).getFoodName());
		}
		else if(newCart.foods.size() < 3) {
			item1.setText(newCart.foods.get(0).getFoodName());
			item2.setText(newCart.foods.get(1).getFoodName());
		}
		else if(newCart.foods.size() < 4) {
			item1.setText(newCart.foods.get(0).getFoodName());
			item2.setText(newCart.foods.get(1).getFoodName());
			item3.setText(newCart.foods.get(2).getFoodName());
		}
		else if(newCart.foods.size() < 5) {
			item1.setText(newCart.foods.get(0).getFoodName());
			item2.setText(newCart.foods.get(1).getFoodName());
			item3.setText(newCart.foods.get(2).getFoodName());
			item4.setText(newCart.foods.get(3).getFoodName());
		}
		else {
				item1.setText(newCart.foods.get(0).getFoodName());
				item2.setText(newCart.foods.get(1).getFoodName());
				item3.setText(newCart.foods.get(2).getFoodName());
				item4.setText(newCart.foods.get(3).getFoodName());
				item5.setText(newCart.foods.get(4).getFoodName());
		}
		
	}
	public void menuButton(ActionEvent event) throws IOException{
 		menu();
 	}
 	public void accountButton(ActionEvent event) throws IOException{
 		account();
 	}
 	public void logoutButton(ActionEvent event) throws IOException{
 		logout();
 	}
 	public void couponButton(ActionEvent event) throws IOException{
 		applyCoupon();
 	}
 	
 	private void applyCoupon() throws IOException{
 		if(user.coupons.isEmpty()) {
 			couponResponse.setText("No Coupons Available!");
 		}
 		else if(!item6.getText().isBlank()) {
 			couponResponse.setText("Only one coupon per order!");
 		}
 		else {
 			user.coupons.remove(0);
 			item6.setText("$5 off Coupon");
 			quantityItem6.setText("1");
 			priceItem6.setText("-5.00");
 			couponResponse.setText("Coupon Applied!");
 		}
 	}

 	private void menu() throws IOException{
 		Main m = new Main();

 		m.menuSceneCustomer(user,newCart);
 	}
 	private void account() throws IOException{
 		Main m = new Main();

 		m.accountSceneCustomer(user,newCart);
 	}
 	private void logout() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
 	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


}
