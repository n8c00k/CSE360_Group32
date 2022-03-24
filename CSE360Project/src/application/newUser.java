package application;

import java.io.IOException;

import application.*;
import application.dataObjects.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class newUser {
	
	public int idCount;

	public newUser() {
		
		}
	
	
	
	@FXML
	private Button createAccount;
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
 	
 	
 	public void createAccount(ActionEvent event) throws IOException{
 		newAccount();
 	}
 	
 	private void newAccount() throws IOException{
 		
 		if (password.getText().toString().equals(confirmPassword.getText().toString())) {
 			String fullName = firstName.getText().toString() + lastName.getText().toString();
 			
 			Customer cus = new Customer(fullName, email.getText().toString(), password.getText().toString());
 			//send to database
 			
 		}
 	}
 	
 	
}
