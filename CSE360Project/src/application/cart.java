package application;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import SQLite_db.Context;
import application.dataObjects.Cart;
import application.dataObjects.Customer;
import application.dataObjects.foodItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class cart implements Initializable{
	public cart() {

	}
	private Customer user;
	private Cart newCart;
	private Double totalprice;

	@FXML
	private Button menu;
	@FXML
	private Button account;
	@FXML
	private Button logout;
	@FXML
	private GridPane cartGrid;
	@FXML
	private Label totalPrice;
	@FXML
	private Button checkout;
	@FXML
	private Button applyCoupon;
	@FXML
	private Label couponResponse;
	
	
	Context con = new Context();
	
	NumberFormat cFmt = NumberFormat.getCurrencyInstance();

	public void initializeUser(Customer newUser, Cart cusCart, Double total) {

		user = newUser;
		newCart = cusCart;
		setUserCart();
		totalprice = total;
		
		totalPrice.setText(cFmt.format(totalprice));

	}
	public void menuButton(ActionEvent event) throws IOException{
 		menu();
 	}
 	public void accountButton(ActionEvent event) throws IOException{
 		account();
 	}
 	public void logoutButton(ActionEvent event) throws IOException{
 		logout();
 	}
 	public void couponButton(ActionEvent event) throws IOException{
 		applyCoupon();
 	}
 	public void checkoutButton(ActionEvent event) throws IOException{
 		checkout();
 	}
 	
 	private void checkout() throws IOException{
 		Main m = new Main();
		if(user.getCard().getCardNumber() == null) {
			couponResponse.setTextFill(Color.RED);
			couponResponse.setText("No card information on file,\nplease go to Account page");
			
		}
		else if(newCart.foods.size() == 0) {
			couponResponse.setText("Nothing in your cart!");
		}
		else {
			setUserCart();
			m.checkoutCustomer(user, newCart);
		}
		
	}
	private void applyCoupon() throws IOException{
 		Label couponlabel = new Label();
 		couponlabel.setText("$5 off coupon");
 		Label qtylabel = new Label("1");
 		Label pricelabel = new Label("-5.00");
 		if(totalprice == 0) {
 			couponResponse.setText("Add food to your cart");
 		}
 		else if(!con.getCoupons(user).isEmpty()) {
 			cartGrid.addRow(cartGrid.getRowCount()+1);
 			cartGrid.add(couponlabel,0,cartGrid.getRowCount());
 			cartGrid.add(qtylabel,1,cartGrid.getRowCount());
 			cartGrid.add(pricelabel,2,cartGrid.getRowCount());
 			//cartGrid.addRow(cartGrid.getRowCount()+1, couponlabel,  qtylabel , pricelabel);
 			totalprice = totalprice -5;
// 			newCart.totalPrice -= 5;
 			con.removeCoupon(con.getCoupons(user).get(0), user);
 			//TODO update total price text field.
 			couponResponse.setTextFill(Color.GREEN);
 			couponResponse.setText("Coupon Applied!");
 			totalPrice.setText(cFmt.format(totalprice));
 		}
 		else {
 			couponResponse.setTextFill(Color.RED);
 			couponResponse.setText("No available Coupons");
 		}
 		
		
 	}
 	private void setUserCart(){
 		cartGrid.getChildren().clear();
 		if(newCart.foods.size() == 0) {
 			couponResponse.setText("Your cart is empty!");
 	 		cartGrid.getChildren().clear();
 	 		totalprice = 0.0;
 	 		totalPrice.setText(cFmt.format(0.00));

 		}
 		else {
 		
 			for(int jj = 0; jj < newCart.foods.size(); jj++) {
 				Label label = new Label();
 				cartGrid.add(label, 0, jj);
 				label.setText(newCart.foods.get(jj).getFoodName());
 				
 			}
 			for(int jj = 0; jj < newCart.quantity.size(); jj++) {
 				Label label = new Label();
 				cartGrid.add(label, 1, jj);
 				label.setText(newCart.quantity.get(jj).toString());
 				
 			}
 			for(int jj = 0; jj < newCart.quantity.size(); jj++) {
 				Label label = new Label();
 				cartGrid.add(label, 2, jj);
 				Double value = (newCart.foods.get(jj).getPrice()*newCart.quantity.get(jj));
 				label.setText(value.toString());
 				
 			}
 			for(int jj = 0; jj < newCart.quantity.size(); jj++) {
 				final Integer innerMi = jj;
 				Button plus = new Button();
 				cartGrid.add(plus, 3, jj);
 				plus.setMaxWidth(Double.MAX_VALUE);
 				plus.setText("+");
 				plus.setOnAction((event) -> {
 					
 					try {
						addQty(newCart.foods.get(innerMi));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 				});
 				
 			}
 			for(int jj = 0; jj < newCart.quantity.size(); jj++) {
 				final Integer innerMi = jj;
 				Button minus = new Button();
 				cartGrid.add(minus, 4, jj);
 				minus.setMaxWidth(Double.MAX_VALUE);
 				minus.setText("-");
 				minus.setOnAction((event) -> {
 					
 					try {
						subQty(newCart.foods.get(innerMi));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 				});
 				
 				
 			}
 		}
 				
 			
 		
 	}

 	private void menu() throws IOException{
 		Main m = new Main();

 		m.menuSceneCustomer(user,newCart,totalprice);
 	}
 	private void account() throws IOException{
 		Main m = new Main();

 		m.accountSceneCustomer(user,newCart,totalprice);
 	}
 	private void logout() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
 	}
 	private void addQty(foodItem food) throws IOException{	
 		newCart.addFood(food,newCart.quantity.get(newCart.foods.indexOf(food))+1);
	 	totalprice += food.getPrice();
	 	totalPrice.setText(cFmt.format(totalprice));	
 		setUserCart();
 	}
 	private void subQty(foodItem food) throws IOException{
 		if(newCart.quantity.get(newCart.foods.indexOf(food)) == 1){	
 			newCart.foods.remove(food);
 			totalPrice.setText(cFmt.format(totalprice));
 			setUserCart();
 		}
 		else if(newCart.quantity.get(newCart.foods.indexOf(food)) == 1 && newCart.foods.size() == 1) {
 			newCart.foods.remove(food);
 			couponResponse.setText("Your cart is empty!");
 		}
 		else {
 			
 			newCart.removeFood(food);
 			totalprice -= food.getPrice();
 			totalPrice.setText(cFmt.format(totalprice));
 			setUserCart();
 		}
	
 	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


}
