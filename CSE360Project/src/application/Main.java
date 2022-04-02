package application;

import java.io.IOException;

import application.dataObjects.Cart;
import application.dataObjects.Customer;
import application.dataObjects.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	private static Stage stg;

		
	@Override
	public void start(Stage primaryStage) {
		//Context con= new Context();
		stg = primaryStage;
		primaryStage.setResizable(false);
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/existingUserScene.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stg.setScene(scene);
			stg.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void changeScene(String fxml) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public void menuSceneCustomer(Customer user, Cart userCart, Double total) throws IOException{

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("menu.fxml"));
		Parent pane = loader.load();
		stg.getScene().setRoot(pane);
		menu controller = loader.getController();
		controller.initializeUser(user, userCart, total);
		
	}
	public void accountSceneCustomer(Customer user, Cart userCart, Double total) throws IOException{

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Account.fxml"));
		Parent pane = loader.load();
		stg.getScene().setRoot(pane);
		account controller = loader.getController();
		controller.initializeUser(user, userCart,total);
	}
	public void cartSceneCustomer(Customer user, Cart userCart,Double total) throws IOException{

	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(getClass().getResource("cart.fxml"));
	Parent pane = loader.load();
	stg.getScene().setRoot(pane);
	cart controller = loader.getController();
	controller.initializeUser(user, userCart,total);
}
	public void checkoutCustomer(Customer user, Cart userCart) throws IOException{

	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(getClass().getResource("Checkout.fxml"));
	Parent pane = loader.load();
	stg.getScene().setRoot(pane);
	Checkout controller = loader.getController();
	controller.initializeUser(user, userCart);
}
	public void employeeMain(Manager manager) throws IOException{

	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(getClass().getResource("employeeMainMenu.fxml"));
	Parent pane = loader.load();
	stg.getScene().setRoot(pane);
	employeeMainMenu controller = loader.getController();
	controller.initializeUser(manager);
}
	public void guestCartScene(Customer user, Cart userCart,Double total) throws IOException{

	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(getClass().getResource("cart.fxml"));
	Parent pane = loader.load();
	stg.getScene().setRoot(pane);
	guestCart controller = loader.getController();
	controller.initializeUser(user, userCart,total);
}
//	public void guestMenuScene(Customer user, Cart userCart,Double total) throws IOException{
//
//	FXMLLoader loader = new FXMLLoader();
//	loader.setLocation(getClass().getResource("cart.fxml"));
//	Parent pane = loader.load();
//	stg.getScene().setRoot(pane);
//	guestMenu controller = loader.getController();
//	controller.initializeUser(user, userCart,total);
//}

	public static void main(String[] args) {
		launch(args);
	}
}
