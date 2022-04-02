package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.Cart;
import application.dataObjects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class existingUser implements Initializable{

	public existingUser() {

	}


	public void initializeUser(User newUser) {

	}




	@FXML
	private Button signIn;
	@FXML
	private Button createAccount;
	@FXML
	private Button contGuest;
	@FXML
 	private Button employeePortal;
 	@FXML
 	private TextField email;
 	@FXML
 	private PasswordField password;
 	@FXML
 	private Label emailError;
 	@FXML
 	private ImageView logo;

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

 			Cart userCart = new Cart();
 			m.menuSceneCustomer(con.getCustomer(cusEmail, cusPassword),userCart,userCart.totalPrice);
 		}
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
 	
 	public void contGuest(ActionEvent event) throws IOException{
 		continueAsGuest();
 	}
 	
 	private void continueAsGuest() throws IOException{
		Main m = new Main();
		//when I added this code this fxml file was not created yet.
		m.changeScene("guestMenu.fxml");
 	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image image = new Image(getClass().getResourceAsStream("/Food Photos/Logo.jpg"));
		logo.setImage(image);
	}


}
