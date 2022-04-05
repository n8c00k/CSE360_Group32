package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.Cart;
import application.dataObjects.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Checkout implements Initializable {

	private Customer user;
	private Cart newCart;
	
	public Checkout() {

	}
	public void initializeUser(Customer newUser, Cart cusCart) {

		user = newUser;
		newCart = cusCart;
		ordersAhead();
		showReceipt();
		
	}

	@FXML
	private Button backHome;
	
	@FXML
	private Label ordersAhead;
	@FXML
	private Label receipt;
	
	Context con = new Context();

	public void backHomeButton(ActionEvent event) throws IOException {
		Main m = new Main();
		
		m.menuSceneCustomer(user, newCart, newCart.totalPrice);
	}
	
	public void showReceipt() {
		receipt.setText(newCart.receipt());
		
		newCart.foods.clear();
		newCart.quantity.clear();
		newCart.totalPrice = 0.00;
	}
	
	public void ordersAhead() {
		ordersAhead.setText(newCart.ordersAhead());
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
