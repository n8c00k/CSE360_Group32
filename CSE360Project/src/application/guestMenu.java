package application;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class guestMenu implements Initializable{
	private Customer user;
	private Cart newCart;
	private Double totalprice;
	
	public guestMenu() {
		
	}

	@FXML
	private Button search;
	@FXML
	private Button cart;
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
	private Button LogIn;
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
	
	

	public void initializeUser(Customer newUser, Cart userCart, Double total) {

		setMenu("Breakfast");
		user = newUser;
		newCart = userCart;
		totalprice = total;
	}
	

 	public void cartButton(ActionEvent event) throws IOException{
 		cart();
 	}
 	public void logInButton(ActionEvent event) throws IOException{
 		logIn();
 	}
 	
 	private void logIn() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
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

 	public void addItem1(ActionEvent event) throws IOException{
 		addToCart(con.getMenu("Breakfast").foods.get(5),qtyItem1);
 	}
 	public void addItem2(ActionEvent event) throws IOException{
 		addToCart(con.getMenu("Breakfast").foods.get(1),qtyItem2);
 	}
 	public void addItem3(ActionEvent event) throws IOException{
 		addToCart(con.getMenu("Breakfast").foods.get(2),qtyItem3);
 	}
 	public void addItem4(ActionEvent event) throws IOException{
 		addToCart(con.getMenu("Breakfast").foods.get(3),qtyItem4);
 	}
 	public void addItem5(ActionEvent event) throws IOException{
 		addToCart(con.getMenu("Breakfast").foods.get(4),qtyItem5);
 	}

 	private void addToCart(foodItem food, TextField qty) throws IOException{
 		Integer quant = Integer.valueOf(qty.getText());	
 		if(quant == 0) {
 			
 		}
 		else if(qty.getText().isBlank()) {
 			
 		}
 		else{	
 			
 			newCart.addFood(food,quant);
//        	newCart.quantity.set(newCart.foods.indexOf(food), quant);
 	 		totalprice += food.getPrice()*newCart.quantity.get(newCart.foods.indexOf(food));
 	 		qty.setText(null);
 	 		System.out.println(totalprice.toString());
 		}
 		
 	}


 	private void cart() throws IOException{
 		Main m = new Main();

 		m.guestCartScene(user,newCart,totalprice);
 	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image image1 = new Image(getClass().getResourceAsStream("/Food Photos/Belgian Waffle.jpg"));
		Image image2 = new Image(getClass().getResourceAsStream("/Food Photos/Strawberry Banana Pancakes.jpg"));
		Image image3 = new Image(getClass().getResourceAsStream("/Food Photos/Double Chocolate Chip Pancakes.jpg"));
		Image image4 = new Image(getClass().getResourceAsStream("/Food Photos/Strawberries Cream Crepes.jpg"));
		Image image5 = new Image(getClass().getResourceAsStream("/Food Photos/French Toast.jpg"));
		
		waffle.setImage(image1);
		strawberryPan.setImage(image2);
		chocolatePan.setImage(image3);
		crepe.setImage(image4);
		frenchToast.setImage(image5);
		
	}

	
}
