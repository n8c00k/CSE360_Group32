package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.dataObjects.User;
import javafx.fxml.Initializable;

public class account implements Initializable{
	
public account() {
		
	}
	



	private User user;
	
	
	public void initializeUser(User newUser) {
		
		user = newUser;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
