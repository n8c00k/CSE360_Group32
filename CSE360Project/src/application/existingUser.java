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

public class existingUser implements Initializable{

	public existingUser() {
		
	}
	private User user;
	
	
	public void initializeUser(User newUser) {
		
		user = newUser;
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
 	@FXML 
 	private Label emailError;
 	
 	Context con = new Context();
	
 	public void userSignIn(ActionEvent event) throws IOException{
 		checkLogin();
 	}
 	
 	private void checkLogin() throws IOException{
 		Main m = new Main();
 		String cusEmail = email.getText().toString();
		String cusPassword = password.getText().toString();
		
 		//if database contains email.getText().toString()
 		if(con.getCustomer(cusEmail, cusPassword ) != null) {
 			
 			
 			m.logInSceneCustomer(con.getCustomer(cusEmail, cusPassword));
 		}
 		// change scene to employee page.fxml
 		else {
 			emailError.setText("Invalid Email or Password");
 		}

 	}
 	
 	public void createAccount(ActionEvent event) throws IOException{
 		createNew();
 	}
 	
 	private void createNew() throws IOException{
		Main m = new Main();
		 		
		m.changeScene("newUser.fxml");
 	}
 	
 	public void employeePortal(ActionEvent event) throws IOException{
 		employeeLogin();
 	}
 	
 	private void employeeLogin() throws IOException {
 		Main m = new Main();
 		
		m.changeScene("employee.fxml");
 	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
 	
	
}
