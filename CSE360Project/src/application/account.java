package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.User;
import application.dataObjects.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class account implements Initializable{

public account() {

	}
	private Customer user;

	@FXML
	private Button menu;
	@FXML
	private Button cart;
	@FXML
	private Button logout;
	@FXML
	private Button update;
	@FXML
	private Button updateInfo;
	@FXML
	private Button AvailCoupon;
	@FXML
	private Button pastOrders;
	@FXML
	private Button contact;
	@FXML
	private AnchorPane updatePane;
	@FXML
	private AnchorPane couponPane;
	@FXML
	private AnchorPane orderPane;
	@FXML
	private AnchorPane contactPane;
	@FXML
	private Label nameLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private Label ccNumLabel;
	@FXML
	private Label ccvLabel;
	@FXML
	private Label expdateLabel;
	@FXML
	private TextField nameText;
	@FXML
	private TextField emailText;
	@FXML
	private TextField passwordText;
	@FXML
	private TextField ccNumText;
	@FXML
	private TextField ccvText;
	@FXML
	private TextField expdateText;
	@FXML
	private Label couponLabel;
	@FXML
	private TextField couponText;
	@FXML
	private Label orderLabel;
	@FXML
	private TextField orderText;
	@FXML
	private Label contactLabel;
	


	public void initializeUser(User newUser) {

		user = (Customer) newUser;
		nameText.setText(user.getName());
		emailText.setText(user.getEmail());
		passwordText.setText(user.getPassword());
		couponTextInput(user);
		pastOrdersTextInput(user);
	}
	Context con = new Context();
	
	public void menuButton(ActionEvent event) throws IOException{
 		menu();
 	}
 	public void cartButton(ActionEvent event) throws IOException{
 		cart();
 	}
 	public void logoutButton(ActionEvent event) throws IOException{
 		logout();
 	}
 	public void updateInfoButton(ActionEvent event) throws IOException{
 		showUpdate();
 	}
	public void availCouponButton(ActionEvent event) throws IOException{
 		showCoupon();
 	}
	public void pastOrderButton(ActionEvent event) throws IOException{
 		showOrders();
 	}
	public void contactButton(ActionEvent event) throws IOException{
 		showContact();
 	}
 	public String couponTextInput(Customer user) {
 		String ret = Integer.valueOf(user.quantityOfCoupons()) + " available for use!";
 		return ret;
 	}
 	public String pastOrdersTextInput(Customer user) {
 		String receipt1 = con.getCarts(user).get(0).receipt();
 		String receipt2 = con.getCarts(user).get(1).receipt();
 		String receipt3 = con.getCarts(user).get(2).receipt();
 		String ret = receipt1 +"\n"+receipt2 +"\n"+receipt3;
 		return ret;
 	}
 	
 	
 	private void logout() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
 	}
 	private void menu() throws IOException{
 		Main m = new Main();

 		m.menuSceneCustomer(user);
 	}
 	private void cart() throws IOException{
 		Main m = new Main();

 		m.cartSceneCustomer(user);
 	}

 	private void hideUpdate() {
 		updatePane.setVisible(false);
 		updatePane.setManaged(false);
 	}
 	private void showUpdate() {
 		updatePane.setVisible(true);
 		updatePane.setManaged(true);
 		hideCoupon();
 		hideOrders();
 		hideContact();
 	}
 	private void hideCoupon() {
 		couponPane.setVisible(false);
 		couponPane.setManaged(false);
 	}
 	private void showCoupon() {
 		couponPane.setVisible(true);
 		couponPane.setManaged(true);
 		hideUpdate();
 		hideOrders();
 		hideContact();
 	}
 	private void hideOrders() {
 		orderPane.setVisible(false);
 		orderPane.setManaged(false);
 	}
 	private void showOrders() {
 		orderPane.setVisible(true);
 		orderPane.setManaged(true);
 		hideCoupon();
 		hideUpdate();
 		hideContact();
 	}
 	private void hideContact() {
 		contactPane.setVisible(false);
 		contactPane.setManaged(false);
 	}
 	private void showContact() {
 		contactPane.setVisible(true);
 		contactPane.setManaged(true);
 		hideCoupon();
 		hideOrders();
 		hideUpdate();
 	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
