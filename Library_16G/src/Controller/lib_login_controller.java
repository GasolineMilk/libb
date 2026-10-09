package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class lib_login_controller implements Initializable {

	database_connection db = new database_connection();
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_login;

    @FXML
    private ImageView img;

    @FXML
    private RadioButton rbt_admin;

    @FXML
    private RadioButton rbt_lib;

    @FXML
    private ToggleGroup role;

    @FXML
    private TextField txt_name;

    @FXML
    private PasswordField txt_pass;

    @FXML
    void click_clear(ActionEvent event) 
    {
    	txt_name.setText("");
    	txt_pass.setText("");
    	
    	rbt_admin.setSelected(false);
    	rbt_lib.setSelected(false);
    }

    @FXML
    void click_login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException 
    {
    	int id = get_id(txt_name.getText());
    	String pass = get_pass(get_id(txt_name.getText()));
    	String role = "";
    	if(rbt_admin.isSelected())
    		role = "admin";
    	
    	if(rbt_lib.isSelected())
    		role = "librariean";
    		
    	if (id != 0 && ! pass.equals("")) 
    	{
    		if(role.equals("admin")) 
    		{
    			Parent root = FXMLLoader.load(getClass().getResource("/View/admin.fxml"));
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
    		}
    		else if (role.equals("librariean")) 
    		{
    			Parent root = FXMLLoader.load(getClass().getResource("/View/librariean.fxml"));
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
    		}
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		String path = "D:/photo/wallpaper/vn-11134207-7ras8-m2nyni1yz9h660.jpg";
		File file = new File(path);

		Image image = new Image(file.toURI().toString());

		img.setImage(image);
		
	}
	public int get_id(String name) throws ClassNotFoundException, SQLException 
	{
		con = db.getDB();
		pstmt = con.prepareStatement("SELECT user_id FROM users WHERE name = ?");
		pstmt.setString(1,name);
		rs = pstmt.executeQuery();
		int id = 0;
		if(rs.next())
			id = rs.getInt(1);
		else
			System.out.println("no name found");
		
		con.close();
		return id;
	}
	public String get_pass(int id) throws ClassNotFoundException, SQLException 
	{
		con = db.getDB();
	    pstmt = con.prepareStatement("SELECT passwords FROM users WHERE user_id = ?");
	    pstmt.setInt(1, id);
	    rs = pstmt.executeQuery();

	    String pass = "";

	    if (rs.next())
	        pass = rs.getString(1);
	    else
	    	System.out.println("no user id found");

	    con.close();
	    return pass;
	}

}
