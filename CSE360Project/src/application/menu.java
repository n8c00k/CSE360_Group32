package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.User;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class menu implements Initializable {
	
	
	private User user;
	
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
	private TextArea desItem1;
	@FXML
	private TextArea desItem2;
	@FXML
	private TextArea desItem3;
	@FXML
	private TextArea desItem4;
	@FXML
	private TextArea desItem5;
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
	
	
	Context con = new Context();
	
	public void initializeUser(User newUser) {
		
		user = newUser;
		
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
 		
 		desItem1.setText(con.getMenu(menu).foods.get(0).foodName + ": " + con.getMenu(menu).foods.get(0).ingredients);
 		priceItem1.setText("$" + con.getMenu(menu).foods.get(0).price.toString());
 		
 		desItem2.setText(con.getMenu(menu).foods.get(1).foodName + ": " + con.getMenu(menu).foods.get(1).ingredients);
 		priceItem2.setText("$" + con.getMenu(menu).foods.get(1).price.toString());
 		
 		desItem3.setText(con.getMenu(menu).foods.get(2).foodName + ": " + con.getMenu(menu).foods.get(2).ingredients);
 		priceItem3.setText("$" + con.getMenu(menu).foods.get(2).price.toString());
 		
 		desItem4.setText(con.getMenu(menu).foods.get(3).foodName + ": " + con.getMenu(menu).foods.get(3).ingredients);
 		priceItem4.setText("$" + con.getMenu(menu).foods.get(3).price.toString());
 		
 		desItem5.setText(con.getMenu(menu).foods.get(4).foodName + ": " + con.getMenu(menu).foods.get(4).ingredients);
 		priceItem5.setText("$" + con.getMenu(menu).foods.get(4).price.toString());
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
		// TODO Auto-generated method stub
		
	}
	
	
}
