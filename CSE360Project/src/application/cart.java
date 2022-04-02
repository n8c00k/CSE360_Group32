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
		if(user.getCard().getCardNumber()== 0) {
			couponResponse.setTextFill(Color.RED);
			couponResponse.setText("No card information on file,\nplease go to Account page");
			System.out.println("fuck lmao");
		}
		else {
			con.addCart(user, newCart);
			m.checkoutCustomer(user, newCart, totalprice);
		}
		
	}
	private void applyCoupon() throws IOException{
 		Label couponlabel = new Label("$5 off coupon");
 		Label qtylabel = new Label("1");
 		Label pricelabel = new Label("-5.00");
 		cartGrid.addColumn(cartGrid.getColumnCount()+1, couponlabel,  qtylabel , pricelabel);
 		totalprice = totalprice -5;
		
 	}
 	private void setUserCart(){
 		cartGrid.getChildren().clear();
 		
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
 			newCart.quantity.set(newCart.foods.indexOf(food),0);
 			totalprice -= food.getPrice();
 			totalPrice.setText(cFmt.format(totalprice));
 			setUserCart();
 		}
 		else if(newCart.quantity.get(newCart.foods.indexOf(food)) == 0) {
 			
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
