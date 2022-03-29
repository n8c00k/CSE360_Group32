package application;

import java.io.IOException;

import application.dataObjects.User;
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
	public void logInSceneCustomer(User user) throws IOException{

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("userMain.fxml"));
		Parent pane = loader.load();
		stg.getScene().setRoot(pane);
		userMain controller = loader.getController();
		controller.initializeUser(user);
		controller.setNameText(user);
	}
	public void menuSceneCustomer(User user) throws IOException{

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Menu.fxml"));
		Parent pane = loader.load();
		stg.getScene().setRoot(pane);
		menu controller = loader.getController();
		controller.initializeUser(user);
		
	}
	public void accountSceneCustomer(User user) throws IOException{

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Account.fxml"));
		Parent pane = loader.load();
		stg.getScene().setRoot(pane);
		account controller = loader.getController();
		controller.initializeUser(user);
	}
	public void cartSceneCustomer(User user) throws IOException{

	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(getClass().getResource("cart.fxml"));
	Parent pane = loader.load();
	stg.getScene().setRoot(pane);
	cart controller = loader.getController();
	controller.initializeUser(user);
}

	public static void main(String[] args) {
		launch(args);
	}
}
