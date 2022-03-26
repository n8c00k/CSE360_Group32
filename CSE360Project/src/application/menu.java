package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.dataObjects.User;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

public class menu implements Initializable {
	
	
	private User user;
	
	public menu() {
		
	}
	
	
	
	@FXML
	private Button search;
	@FXML
	private Button cart;
	@FXML
	private Button account;
	@FXML
	private Button logout;
	@FXML
	private TextField searchItem;
	@FXML
	private Button addItem1;
	@FXML
	private Button addItem2;
	@FXML
	private Button addItem3;
	@FXML
	private Button addItem4;
	@FXML
	private Button addItem5;
	@FXML
	private TextField qtyItem1;
	@FXML
	private TextField qtyItem2;
	@FXML
	private TextField qtyItem3;
	@FXML
	private TextField qtyItem4;
	@FXML
	private TextField qtyItem5;
	
	
	public void initializeUser(User newUser) {
		
		user = newUser;
	}
	
	public void accountButton(ActionEvent event) throws IOException{
 		account();
 	}
 	public void cartButton(ActionEvent event) throws IOException{
 		cart();
 	}
 	public void logoutButton(ActionEvent event) throws IOException{
 		logout();
 	}
 	
 	
 	private void logout() throws IOException{
 		Main m = new Main();
 				
 		m.changeScene("existingUserScene.fxml");
 	}
 	
 	private void account() throws IOException{
 		Main m = new Main();
 				
 		m.accountSceneCustomer(user);
 	}
 	
 	private void cart() throws IOException{
 		Main m = new Main();
 				
 		m.cartSceneCustomer(user);
 	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
