package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.dataObjects.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class account implements Initializable{

public account() {

	}

	@FXML
	private Button menu;
	@FXML
	private Button cart;
	@FXML
	private Button logOut;

	private User user;


	public void initializeUser(User newUser) {

		user = newUser;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
