package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Checkout implements Initializable {

	public Checkout() {

	}

	@FXML
	private Button backHome;
	
	@FXML
	private Label ordersAhead;
	@FXML
	private Label receipt;
	
	

	public void backHomeButton(ActionEvent event) throws IOException {
		Main m = new Main();
		
		//m.changeScene("");
	}
	
	public void showReceipt() {
		
	}
	
	public void ordersAhead() {
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
