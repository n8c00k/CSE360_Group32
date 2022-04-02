package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import SQLite_db.Context;
import application.dataObjects.Manager;
import application.dataObjects.foodItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class employeeMainMenu implements Initializable {
	
	public employeeMainMenu() {
		
	}
	
	
	private Manager user;
	
	public void initializeUser(Manager newUser) {

		user = newUser;
		setMenu("Breakfast");
		
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
	
	Context con = new Context();
	
	
	public void couponsButton(ActionEvent event) throws IOException{
		coupons();
	}
	public void logoutButton(ActionEvent event) throws IOException{
		logout();
	}
	public void saveItem1Button(ActionEvent event) throws IOException{
 		saveItem(con.getMenu("Breakfast").foods.get(5),nameItem1,desItem1,priceItem1);
 	}
	public void saveItem2Button(ActionEvent event) throws IOException{
		saveItem(con.getMenu("Breakfast").foods.get(1),nameItem2,desItem2,priceItem2);
 	}
	public void saveItem3Button(ActionEvent event) throws IOException{
		saveItem(con.getMenu("Breakfast").foods.get(2),nameItem3,desItem3,priceItem3);
 	}
	public void saveItem4Button(ActionEvent event) throws IOException{
		saveItem(con.getMenu("Breakfast").foods.get(3),nameItem4,desItem4,priceItem4);
 	}
	public void saveItem5Button(ActionEvent event) throws IOException{
		saveItem(con.getMenu("Breakfast").foods.get(4),nameItem5,desItem5,priceItem5);
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
	
	private void saveItem(foodItem food,TextField nameTxt,TextField desText,TextField priceText) throws IOException{
		food.setFoodName(nameTxt.getText());
		food.setIngredients(desText.getText());
		food.setPrice(Double.valueOf(priceText.getText().replace("$", "")));
		con.setFoodItem(con.getMenu("Breakfast"), food);
	}
	
	private void logout() throws IOException{
 		Main m = new Main();

 		m.changeScene("existingUserScene.fxml");
 	}
	private void coupons() throws IOException{
		Main m = new Main();

// 		m.changeScene("employeeCoupon.fxml");
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
