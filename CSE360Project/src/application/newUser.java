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
import javafx.scene.text.Text;

public class newUser {
	
	

	public newUser() {
		
		}
	
	
	
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
 	
 	private void newAccount() throws IOException{
 			String fullName = firstName.getText().toString() + " " + lastName.getText().toString();
 			String cusEmail = email.getText().toString();
 			String cusPassword = password.getText().toString();
 			String confirmCusPassword = confirmPassword.getText().toString();
 			
 		if (cusPassword.equals(confirmCusPassword)) {
 			
 			
 			Customer cus = new Customer( fullName, cusEmail, cusPassword);
 			//cus.setId( get latest ID number from DB + 1);
 			//System.out.println("Customer: "+ fullName + "\nEmail: " + cusEmail + "\nPassword: " + cusPassword
 			//		+ "\nID: "+ );
 			//send to database
 			
 			Main m = new Main();
 			m.changeScene("existingUserScene.fxml");
 		}
 		else {
 				passwordError.setText("Passwords do not match");
 		}
 	}
 	
 	public void backButton(ActionEvent event) throws IOException{
 		backToLogin();
 	}
 	
 	private void backToLogin() throws IOException{
 		Main m = new Main();
		m.changeScene("existingUserScene.fxml");
 	}
 	
 	
}
