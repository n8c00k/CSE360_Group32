package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.Coupon;
import application.dataObjects.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class employeeCoupon implements Initializable{
	
	private Manager manager;
	employeeCoupon(){
		
	}

	@FXML
	private Button menu;
	@FXML
	private Button logout;
	@FXML
	private Button awardCoupon;
	@FXML
	private TextField cusEmail;
	@FXML
	private Label couponResponse;
	
	Context con = new Context();
	
	public void menuButton(ActionEvent event) throws IOException{
		menu();
	}
	
	public void logoutButton(ActionEvent event) throws IOException{
		logout();
	}
	public void awardCouponButton(ActionEvent event) throws IOException{
		awardCoupon();
	}
	

	private void menu() throws IOException{
 		Main m = new Main();
 		m.employeeMain(manager);
	}
	
	private void logout() throws IOException{
 		Main m = new Main();
 		m.changeScene("existingUserScene.fxml");
	}
	private void awardCoupon() {
		if(con.getCustomer(cusEmail.getText()) != null) {
			Coupon newCoup = new Coupon();
			con.getCustomer(cusEmail.getText()).coupons.add(newCoup);
			couponResponse.setText("Coupon has been rewarded!");
		}
		else {
			couponResponse.setText("User does not exist!");

		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void initializeUser(Manager user) {
		manager = user;
	}

}
