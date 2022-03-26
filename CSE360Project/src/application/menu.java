package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.dataObjects.User;
import javafx.fxml.*;
import javafx.scene.control.*;

public class menu implements Initializable {
	
	
	private User user;
	
	public menu() {
		
	}
	
	
	@FXML
	private Button search;
	@FXML
	private Button cart;
	@FXML
	private Button account;
	@FXML
	private Button logout;
	@FXML
	private TextField searchItem;

	public void initializeUser(User newUser) {
		
		user = newUser;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
