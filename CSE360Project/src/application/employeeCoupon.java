package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class employeeCoupon implements Initializable{
	employeeCoupon(){
		
	}

	@FXML
	private Button menu;
	@FXML
	private Button logout;
	@FXML
	private TextField cusEmail;
	
	private void menu() throws IOException{
 		Main m = new Main();
 		
	}
	
	private void logout() throws IOException{
 		Main m = new Main();
 		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
