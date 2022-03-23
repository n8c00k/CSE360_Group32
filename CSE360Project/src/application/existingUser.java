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
 	private Button employeePortal;
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
 		//check if password.getText.toString.equals(database password for that email)
 		
 		m.changeScene("whatever the following scene.fxml is");
 	}
 	
 	
	
}
