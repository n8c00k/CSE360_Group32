package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class cart implements Initializable{
	public cart() {
		
	}
	private User user;
	
	
	@FXML 
	private Button menu;
	
	@FXML 
	private Button account;
	
	@FXML 
	private Button logout;
	
	@FXML 
	private Label item1;
	
	@FXML 
	private Label item2;
	
	@FXML 
	private Label item3;
	
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
	private TextField totalPrice;
	
	@FXML 
	private Button checkout;
	
	Context con = new Context();

	
	public void initializeUser(User newUser) {
		
		user = newUser;
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
