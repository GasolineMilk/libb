package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class admin_controller {
	
	

    @FXML
    private Button btn_author;

    @FXML
    private Button btn_book;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_member;

    @FXML
    private Button btn_pub;

    @FXML
    private Label labwecome;

    @FXML
    private AnchorPane lib_pane;

    @FXML
    void click_author(ActionEvent event) throws IOException 
    {
    	lib_pane.getChildren().clear();
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/combo.fxml"));
    	lib_pane.getChildren().add(pane);
    }

    @FXML
    void click_book(ActionEvent event) throws IOException 
    {
    	lib_pane.getChildren().clear();
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/book.fxml"));
    	lib_pane.getChildren().add(pane);
    }

    @FXML
    void click_logout(ActionEvent event) throws IOException 
    {
    	Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void click_member(ActionEvent event) throws IOException 
    {
    	lib_pane.getChildren().clear();
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/member.fxml"));
    	lib_pane.getChildren().add(pane);
    }

    @FXML
    void click_pub(ActionEvent event) throws IOException 
    {
    	lib_pane.getChildren().clear();
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/combo.fxml"));
    	lib_pane.getChildren().add(pane);
    }
    @FXML
    void click_user(ActionEvent event) throws IOException 
    {
    	lib_pane.getChildren().clear();
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/user.fxml"));
    	lib_pane.getChildren().add(pane);
    }

}
