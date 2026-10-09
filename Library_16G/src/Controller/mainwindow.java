package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainwindow extends Application 
{

	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
//		Parent root = FXMLLoader.load(getClass().getResource("/View/book.fxml"));
		
//		Parent root = FXMLLoader.load(getClass().getResource("/View/member.fxml"));
		
//		Parent root = FXMLLoader.load(getClass().getResource("/View/user.fxml"));
		
//		Parent root = FXMLLoader.load(getClass().getResource("/View/librariean.fxml"));S
		
		Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
		
//		Parent root = FXMLLoader.load(getClass().getResource("/View/Author.fxml"));
		
//		Parent root = FXMLLoader.load(getClass().getResource("/View/Category.fxml"));
		
//		Parent root = FXMLLoader.load(getClass().getResource("/View/Publisher.fxml"));
		
		
		
		System.out.println(Thread.activeCount());
		
		Scene scene = new Scene(root);
		
//		scene.getStylesheets().add("/caculator/style.css");
		stage.setScene(scene);
		stage.show();		
		
	}

}