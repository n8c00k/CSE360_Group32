package application;

import java.io.IOException;


import SQLite_db.Context;
import application.*;
import application.dataObjects.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class newUser {
	
	

	public newUser() {
		
		}
	
	Context con = new Context();
	
	@FXML
	private Button createAccount;
	@FXML
	private Button back;
 	@FXML
 	private TextField firstName;
 	@FXML
 	private TextField lastName;
 	@FXML
 	private TextField email;
 	@FXML 
 	private PasswordField password;
 	@FXML 
 	private PasswordField confirmPassword;
 	@FXML
 	private Label emailError;
 	@FXML
 	private Label passwordError;
 	
 	
 	public void createAccount(ActionEvent event) throws IOException{
 		newAccount();
 	}
 	public void backButton(ActionEvent event) throws IOException{
 		backToLogin();
 	}
 	
 	private void newAccount() throws IOException{
 			String fullName = firstName.getText().toString() + " " + lastName.getText().toString();
 			String cusEmail = email.getText().toString();
 			String cusPassword = password.getText().toString();
 			String confirmCusPassword = confirmPassword.getText().toString();
 			
 		if (con.getUser(cusEmail, confirmCusPassword) != null) {
 			emailError.setText("User already exists");
 		}
 		else if (!cusPassword.equals(confirmCusPassword)) {
 			
 			passwordError.setText("Passwords do not match");
 			
 		}
 		else {
			Customer cus = new Customer( fullName, cusEmail, cusPassword);
			 			
			con.setCustomer(cus);
			 			
			Main m = new Main();
			m.changeScene("existingUserScene.fxml");
 		}
 	}
 	
 	private void backToLogin() throws IOException{
 		Main m = new Main();
		m.changeScene("existingUserScene.fxml");
 	}
 	
 	
}
