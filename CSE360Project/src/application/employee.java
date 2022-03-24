package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class employee {
	
	public employee() {
			
		}
	
	@FXML
	private Button signIn; 
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

}
