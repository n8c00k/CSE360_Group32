package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
		
	}

	@FXML
	private Button backHome;
	
	@FXML
	private Label ordersAhead;
	@FXML
	private Label receipt;
	
	

	public void backHomeButton(ActionEvent event) throws IOException {
		Main m = new Main();
		
		m.accountSceneCustomer(user, newCart, newCart.totalPrice);
	}
	
	public void showReceipt() {
		newCart.receipt();
	}
	
	public void ordersAhead() {
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
