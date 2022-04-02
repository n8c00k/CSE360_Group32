package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class employeeMainMenu implements Initializable {
	public employeeMainMenu() {
		
	}
	
	@FXML
	private Button coupons;
	@FXML
	private Button LogOut;
	
	@FXML
	private TextField priceItem1;
	@FXML
	private TextField priceItem2;
	@FXML
	private TextField priceItem3;
	@FXML
	private TextField priceItem4;
	@FXML
	private TextField priceItem5;
	
	@FXML
	private Button saveItem1;
	@FXML
	private Button saveItem2;
	@FXML
	private Button saveItem3;
	@FXML
	private Button saveItem4;
	@FXML
	private Button saveItem5;
	
	
	@FXML
	private TextField desItem1;
	@FXML
	private TextField desItem2;
	@FXML
	private TextField desItem3;
	@FXML
	private TextField desItem4;
	@FXML
	private TextField desItem5;
	
	@FXML
	private TextField nameItem1;
	@FXML
	private TextField nameItem2;
	@FXML
	private TextField nameItem3;
	@FXML
	private TextField nameItem4;
	@FXML
	private TextField nameItem5;
	
	
	
	public void couponsButton(ActionEvent event) throws IOException{
		
	}
	public void saveItem1Button(ActionEvent event) throws IOException{
 		
 	}
	public void saveItem2Button(ActionEvent event) throws IOException{
 		
 	}
	public void saveItem3Button(ActionEvent event) throws IOException{
 		
 	}
	public void saveItem4Button(ActionEvent event) throws IOException{
 		
 	}
	public void saveItem5Button(ActionEvent event) throws IOException{
 		
 	}
	
	
	private void logout() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
 	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
