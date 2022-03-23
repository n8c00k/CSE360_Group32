package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class existingUser {

	public existingUser() {
		
	}
	
	@FXML
	private Button signIn;
	@FXML
	private Button createAccount;
	@FXML
 	private Button employeePortal; //is the database going to have a different storage for employees? if not just a generic login should be in place.
 	@FXML
 	private TextField email;
 	@FXML 
 	private PasswordField password;
	
 	public void userSignIn(ActionEvent event) throws IOException{
 		checkLogin();
 	}
 	
 	private void checkLogin() throws IOException{
 		Main m = new Main();
 		
 		//if database contains email.getText().toString()
 		// if employee login blah blah
 		// change scene to employee page.fxml
 		//check if password.getText.toString.equals(database password for that email)
 		
 		m.changeScene("whatever the following scene.fxml is");
 		
 		//else
 		//show login error label
 	}
 	
 	public void createAccount(ActionEvent event) throws IOException{
 		createNew();
 	}
 	
 	private void createNew() throws IOException{
		Main m = new Main();
		 		
		 		//m.changeScene("createAccount.fxml");
 	}
 	
 	
	
}
