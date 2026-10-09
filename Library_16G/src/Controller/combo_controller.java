package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class combo_controller {

    @FXML
    private AnchorPane author_pane;

    @FXML
    private AnchorPane cate_pane;

    @FXML
    private AnchorPane pub_pane;

    @FXML
    void btn_author(ActionEvent event) throws IOException 
    {
    	cate_pane.getChildren().clear();
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Author.fxml"));
    	cate_pane.getChildren().add(pane);
    }

    @FXML
    void btn_category(ActionEvent event) throws IOException 
    {
    	cate_pane.getChildren().clear();
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Category.fxml"));
    	cate_pane.getChildren().add(pane);
    }

    @FXML
    void btn_publisher(ActionEvent event) throws IOException 
    {
    	cate_pane.getChildren().clear();
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Publisher.fxml"));
    	cate_pane.getChildren().add(pane);
    }

}
