package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class userMain implements Initializable{

	public userMain() {

	}

	private User user;

	@FXML
	private Button menu;

	@FXML
	private Button account;

	@FXML
	private Button cart;

	@FXML
	private Button logOut;

	@FXML
	private Label name;

	Context con = new Context();




	public void initializeUser(User newUser) {
			
			user = newUser;
			setNameText(newUser);
	}

	public void setNameText(User user){
 		name.setText("Welcome " + user.getName() + "!");
 	}

 	public void menuButton(ActionEvent event) throws IOException{
 		menu();
 	}
 	public void accountButton(ActionEvent event) throws IOException{
 		account();
 	}
 	public void cartButton(ActionEvent event) throws IOException{
 		cart();
 	}
 	public void logoutButton(ActionEvent event) throws IOException{
 		logout();
 	}


 	private void logout() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
 	}
 	private void menu() throws IOException{
 		Main m = new Main();

 		m.menuSceneCustomer(user);
 	}

 	private void account() throws IOException{
 		Main m = new Main();

 		m.accountSceneCustomer(user);
 	}

 	private void cart() throws IOException{
 		Main m = new Main();

 		m.cartSceneCustomer(user);
 	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


}
