package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.dataObjects.Cart;
import application.dataObjects.Customer;
import application.dataObjects.foodItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

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
	private Label totalPrice;
	
	
	public void menuButton(ActionEvent event) throws IOException{
 		menu();
 	}
	
	private void menu() throws IOException{
 		Main m = new Main();

 		m.menuSceneCustomer(user,newCart,totalprice);
 	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
 	
	
	

}
