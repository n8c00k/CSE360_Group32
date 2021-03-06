package application;

import java.io.IOException;

import SQLite_db.Context;
import application.dataObjects.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class employee {

	public employee() {

		}
	private Manager user;

	@FXML
	private Button signIn;
	@FXML
	private Button back;
 	@FXML
 	private TextField email;
 	@FXML
 	private PasswordField password;
 	@FXML
	private Label emailError;
 	Context con = new Context();
 	
 	

 	public void userSignIn(ActionEvent event) throws IOException{
 		checkLogin();
 	}
	public void backButton(ActionEvent event) throws IOException{
 		backToLogin();
 	}

 	private void checkLogin() throws IOException{
 		Main m = new Main();

 		String adminEmail = email.getText().toString();
		String adminPassword = password.getText().toString();

 		//if database contains email.getText().toString()
 		if(con.getManager(adminEmail, adminPassword ) != null) {
 			user = con.getManager(adminEmail, adminPassword);
 			m.employeeMain(user);
 		}
 		else {
 			emailError.setText("Invalid Email or Password");
 		}

 	}

 	private void backToLogin() throws IOException{
 		Main m = new Main();
		m.changeScene("existingUserScene.fxml");
 	}

}
