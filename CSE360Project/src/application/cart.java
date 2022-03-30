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
	private Cart userCart;

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
	private TextField quantityItem1;

	@FXML
	private TextField priceItem1;

	@FXML
	private TextField quantityItem2;

	@FXML
	private TextField priceItem2;

	@FXML
	private TextField quantityItem3;

	@FXML
	private TextField priceItem3;
	@FXML
	private TextField quantityItem4;

	@FXML
	private TextField priceItem4;
	@FXML
	private TextField quantityItem5;

	@FXML
	private TextField priceItem5;
	@FXML
	private TextField quantityItem6;

	@FXML
	private TextField priceItem6;


	@FXML
	private TextField totalPrice;

	@FXML
	private Button checkout;
	@FXML
	private Button applyCoupon;
	@FXML
	private Label couponResponse;

	Context con = new Context();


	public void initializeUser(User newUser) {

		user = (Customer) newUser;
		if (user.getCart().isEmpty()) {
			Cart newCart = new Cart();
			userCart = newCart;
		}
		else {
			userCart = user.getCartIndex(user.cart.size());
		}
		if(userCart.foods.isEmpty()){
		}
		else if(userCart.foods.size() < 2) {
			item1.setText(userCart.foods.get(0).getFoodName());
		}
		else if(userCart.foods.size() < 3) {
			item1.setText(userCart.foods.get(0).getFoodName());
			item2.setText(userCart.foods.get(1).getFoodName());
		}
		else if(userCart.foods.size() < 4) {
			item1.setText(userCart.foods.get(0).getFoodName());
			item2.setText(userCart.foods.get(1).getFoodName());
			item3.setText(userCart.foods.get(2).getFoodName());
		}
		else if(userCart.foods.size() < 5) {
			item1.setText(userCart.foods.get(0).getFoodName());
			item2.setText(userCart.foods.get(1).getFoodName());
			item3.setText(userCart.foods.get(2).getFoodName());
			item4.setText(userCart.foods.get(3).getFoodName());
		}
		else {
				item1.setText(userCart.foods.get(0).getFoodName());
				item2.setText(userCart.foods.get(1).getFoodName());
				item3.setText(userCart.foods.get(2).getFoodName());
				item4.setText(userCart.foods.get(3).getFoodName());
				item5.setText(userCart.foods.get(4).getFoodName());
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

 		m.menuSceneCustomer(user);
 	}
 	private void account() throws IOException{
 		Main m = new Main();

 		m.accountSceneCustomer(user);
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
