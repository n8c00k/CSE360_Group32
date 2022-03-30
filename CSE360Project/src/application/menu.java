package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.Customer;
import application.dataObjects.Menu;
import application.dataObjects.User;
import application.dataObjects.foodItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class menu implements Initializable {


	private Customer user;
	private Menu breakfastMenu;

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
	@FXML
	private Button addItem1;
	@FXML
	private Button addItem2;
	@FXML
	private Button addItem3;
	@FXML
	private Button addItem4;
	@FXML
	private Button addItem5;
	@FXML
	private TextField qtyItem1;
	@FXML
	private TextField qtyItem2;
	@FXML
	private TextField qtyItem3;
	@FXML
	private TextField qtyItem4;
	@FXML
	private TextField qtyItem5;
	@FXML
	private Label desItem1;
	@FXML
	private Label desItem2;
	@FXML
	private Label desItem3;
	@FXML
	private Label desItem4;
	@FXML
	private Label desItem5;
	@FXML
	private Text priceItem1;
	@FXML
	private Text priceItem2;
	@FXML
	private Text priceItem3;
	@FXML
	private Text priceItem4;
	@FXML
	private Text priceItem5;
	@FXML
	private Text nameItem1;
	@FXML
	private Text nameItem2;
	@FXML
	private Text nameItem3;
	@FXML
	private Text nameItem4;
	@FXML
	private Text nameItem5;
	@FXML
	private ImageView waffle;
	@FXML
	private ImageView strawberryPan;
	@FXML
	private ImageView chocolatePan;
	@FXML
	private ImageView crepe;
	@FXML
	private ImageView frenchToast;
	


	Context con = new Context();
	
	

	public void initializeUser(User newUser) {

		user = (Customer) newUser;
		setMenu("Breakfast");
		
	}
	
	

	public void accountButton(ActionEvent event) throws IOException{
 		account();
 	}
 	public void cartButton(ActionEvent event) throws IOException{
 		cart();
 	}
 	public void logoutButton(ActionEvent event) throws IOException{
 		logout();
 	}
 	public void setMenu(String menu) {
 		
 		con.getMenu(menu);

 		nameItem1.setText(con.getMenu(menu).foods.get(5).getFoodName());
 		desItem1.setText(con.getMenu(menu).foods.get(5).getIngredients());
 		priceItem1.setText("$" + con.getMenu(menu).foods.get(5).getPrice());

 		nameItem2.setText(con.getMenu(menu).foods.get(1).getFoodName());
 		desItem2.setText(con.getMenu(menu).foods.get(1).getIngredients());
 		priceItem2.setText("$" + con.getMenu(menu).foods.get(1).getPrice());

 		nameItem3.setText(con.getMenu(menu).foods.get(2).getFoodName());
 		desItem3.setText(con.getMenu(menu).foods.get(2).getIngredients());
 		priceItem3.setText("$" + con.getMenu(menu).foods.get(2).getPrice());

 		nameItem4.setText(con.getMenu(menu).foods.get(3).getFoodName());
 		desItem4.setText(con.getMenu(menu).foods.get(3).getIngredients());
 		priceItem4.setText("$" + con.getMenu(menu).foods.get(3).getPrice());

 		nameItem5.setText(con.getMenu(menu).foods.get(4).getFoodName());
 		desItem5.setText(con.getMenu(menu).foods.get(4).getIngredients());
 		priceItem5.setText("$" + con.getMenu(menu).foods.get(4).getPrice());
 	}

 	public void addItem(ActionEvent event) throws IOException{
 		if(addItem1.isPressed()) {
 			addToCart(breakfastMenu.foods.get(0),qtyItem1);
 			qtyItem1.setText(null);
 		}
 		else if(addItem2.isPressed()) {
 			addToCart(breakfastMenu.foods.get(1),qtyItem2);
 		}
 		else if(addItem3.isPressed()) {
 			addToCart(breakfastMenu.foods.get(2),qtyItem3);
 		}
 		else if(addItem4.isPressed()) {
 			addToCart(breakfastMenu.foods.get(3),qtyItem4);
 		}
 		else if(addItem5.isPressed()) {
 			addToCart(breakfastMenu.foods.get(4),qtyItem5);
 		}
 	}

 	private void addToCart(foodItem food, TextField qty) throws IOException{
 		Integer quantity;
 		food = con.getFoodItem(food.foodName);
 		quantity = Integer.parseInt(qty.getText().toString());

 		user.cart.get(0).foods.add(food);
 		user.cart.get(0).quantity.add(quantity);
 		qty.setText(null);
 	}

 	private void logout() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
 	}

 	private void account() throws IOException{
 		Main m = new Main();

 		m.accountSceneCustomer(user);
 	}

 	private void cart() throws IOException{
 		Main m = new Main();

 		m.cartSceneCustomer(user);
 	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image image1 = new Image(getClass().getResourceAsStream("/Food Photos/Belgian Waffle.jpg"));
		Image image2 = new Image(getClass().getResourceAsStream("/Food Photos/Strawberry Banana Pancakes.jpg"));
		Image image3 = new Image(getClass().getResourceAsStream("/Food Photos/Double Chocolate Chip Pancakes.jpg"));
		Image image4 = new Image(getClass().getResourceAsStream("/Food Photos/Strawberry Cream Crepes.jpg"));
		Image image5 = new Image(getClass().getResourceAsStream("/Food Photos/French Toast.jpg"));
		
		waffle.setImage(image1);
		strawberryPan.setImage(image2);
		chocolatePan.setImage(image3);
		crepe.setImage(image4);
		frenchToast.setImage(image5);
		
	}


}
