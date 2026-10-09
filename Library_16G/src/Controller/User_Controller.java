package Controller;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class User_Controller implements Initializable {

	database_connection db = new database_connection();
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	users u;
	
	ObservableList<users> ulist = FXCollections.observableArrayList();
    @FXML
    private ToggleGroup Gender;
    
    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_Clear;

    @FXML
    private Button btn_Register;

    @FXML
    private Button btn_Upload;

    @FXML
    private ComboBox<?> cb_Role;

    @FXML
    private TableColumn<?, ?> col_Address;

    @FXML
    private TableColumn<?, ?> col_Dob;

    @FXML
    private TableColumn<?, ?> col_Email;

    @FXML
    private TableColumn<?, ?> col_Gender;

    @FXML
    private TableColumn<?, ?> col_Image;

    @FXML
    private TableColumn<?, ?> col_Join_Date;

    @FXML
    private TableColumn<?, ?> col_Name;

    @FXML
    private TableColumn<?, ?> col_Password;

    @FXML
    private TableColumn<?, ?> col_Phone;

    @FXML
    private TableColumn<?, ?> col_Role;

    @FXML
    private TableColumn<?, ?> col_User_ID;

    @FXML
    private DatePicker dp_Dob;

    @FXML
    private DatePicker dp_Join;

    @FXML
    private ImageView img;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblDob;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblJoin;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblRole;

    @FXML
    private Label lblSearch;
    
    @FXML
    private Label lbl_com_pass;

    @FXML
    private AnchorPane pane;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbMale;
    
    @FXML
    private RadioButton rbt_admin;

    @FXML
    private RadioButton rbt_lib;

    @FXML
    private TableView<users> tbl_User;

    @FXML
    private TextArea txt_address;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_pass;

    @FXML
    private TextField txt_phone;

    @FXML
    private TextField txt_search;
    
    @FXML
    private TextField txt_com_pass;

    @FXML
    void click_Clear(ActionEvent event) 
    {
    	
        txt_name.clear();
        txt_pass.clear();
        txt_com_pass.clear();
        txt_email.clear();
        txt_phone.clear();
        txt_address.clear();
        txt_search.clear();

        dp_Dob.setValue(null);
        dp_Join.setValue(LocalDate.now());

        rbFemale.setSelected(false);
        rbMale.setSelected(false);
      
        rbt_admin.setSelected(false);
        rbt_lib.setSelected(false);

        img.setImage(null);

        btn_Register.setText("Register");
    }
    
    @FXML
    void click_delete(ActionEvent event) throws ClassNotFoundException, SQLException 
    {
    	u = tbl_User.getSelectionModel().getSelectedItem();
    	delete_user();
    }

    @FXML
    void click_update(ActionEvent event) 
    {
    	
    	img.setImage(null);
    	
    	u = tbl_User.getSelectionModel().getSelectedItem();
    	
    	btn_Register.setText("Edit");
    	
    	if (u != null) 
    	{
    		txt_name.setText(u.getName());
    		txt_pass.setText(u.getPasswords());
    		txt_com_pass.setText(u.getPasswords());
    		
    		dp_Dob.setValue(u.getDate_of_birth());
    		txt_email.setText(u.getEmail());
    		txt_phone.setText(u.getPhone_no());
    		txt_address.setText(u.getAddress());
    		
    		if (u.getRole().equals("admin")) 
    			rbt_admin.setSelected(true);
    		
    		else if (u.getRole().equals("librariean")) 
    			rbt_lib.setSelected(true);
    		
    		dp_Join.setValue(u.getJoin_date());
    		
    		if (u.getGender().equals("male")) 
    			rbMale.setSelected(true);
    		
    		else if (u.getGender().equals("female")) 
    			rbFemale.setSelected(true);
    		
    		img.setImage( new Image(u.getImage()));
    	}
    }

    @FXML
    void click_Enter(ActionEvent event) throws ClassNotFoundException, SQLException 
    {
    	String name = txt_search.getText();
    	
    	ulist.clear();
    	ulist = get_user( name );
    	tbl_User.setItems(ulist);
    }

    @FXML
    void click_Register(ActionEvent event) throws ClassNotFoundException, SQLException 
    {
    	if (btn_Register.getText().equals("Register")) 
    	{
    		reg_user();
    		System.out.println("Register button clicked!");
    	}
    	
    	else if (btn_Register.getText().equals("Edit"))
    		update_user();
    }

    @FXML
    void click_upload(ActionEvent event) 
    {
    	FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose Image");

        chooser.getExtensionFilters().add( new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		File file = chooser.showOpenDialog(stage);
		
		if (file != null) 
		{
			Image image;
			try {
				image = new Image(file.toURI().toString());
				img.setImage(image);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_User_ID.setCellValueFactory(new PropertyValueFactory<>("user_id"));

		col_Name.setCellValueFactory(new PropertyValueFactory<>("name"));

		col_Password.setCellValueFactory(new PropertyValueFactory<>("passwords"));

		col_Dob.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));

		col_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

		col_Email.setCellValueFactory(new PropertyValueFactory<>("email"));

		col_Phone.setCellValueFactory(new PropertyValueFactory<>("phone_no"));

		col_Role.setCellValueFactory(new PropertyValueFactory<>("role"));

		col_Address.setCellValueFactory(new PropertyValueFactory<>("address"));

		col_Join_Date.setCellValueFactory(new PropertyValueFactory<>("join_date"));

		col_Image.setCellValueFactory(new PropertyValueFactory<>("image"));
		
		ulist.clear();
    	try {
			ulist = get_user();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	tbl_User.setItems(ulist);
    	
    	dp_Join.setValue(LocalDate.now());
	}
	
	public ObservableList<users> get_user() throws SQLException, ClassNotFoundException
	{
		con = db.getDB();
		pstmt = con.prepareStatement("SELECT * FROM users");
		
		rs = pstmt.executeQuery();
		while(rs.next()) 
		{
			int uid = rs.getInt(1);
			String n = rs.getString(2);
			String pass = rs.getString(3);
			LocalDate dob = rs.getDate(4).toLocalDate();
			String g = rs.getString(5);
			String e = rs.getString(6);
			String p = rs.getString(7);
			String r = rs.getString(8);
			String a = rs.getString(9);
			LocalDate j_date = rs.getDate(10).toLocalDate();
			String img = rs.getString(11);
			
			users m = new users(uid, n, pass, dob, g, e, p, r, a, j_date, img);
			
			ulist.add(m);
		}
		return ulist;
	}
	
	public ObservableList<users> get_user(String name) throws SQLException, ClassNotFoundException
	{
		con = db.getDB();
		pstmt = con.prepareStatement("SELECT * FROM member Where name = ?");
		
		pstmt.setString(1, name);
		
		rs = pstmt.executeQuery();
		while(rs.next()) 
		{
			int uid = rs.getInt(1);
			String n = rs.getString(2);
			String pass = rs.getString(3);
			LocalDate dob = rs.getDate(4).toLocalDate();
			String g = rs.getString(5);
			String e = rs.getString(6);
			String p = rs.getString(7);
			String r = rs.getString(8);
			String a = rs.getString(9);
			LocalDate j_date = rs.getDate(10).toLocalDate();
			String img = rs.getString(11);
			
			users m = new users(uid, n, pass, dob, g, e, p, r, a, j_date, img);
			
			ulist.add(m);
		}
		return ulist;
	}
	public void reg_user() throws SQLException, ClassNotFoundException 
	{
		String n = txt_name.getText();
    	
		if (dp_Dob.getValue() == null || dp_Join.getValue() == null) {
		    JOptionPane.showMessageDialog(null, "Please select both dates!");
		    return;
		}
		if (!rbMale.isSelected() && !rbFemale.isSelected()) {
		    JOptionPane.showMessageDialog(null, "Please select gender!");
		    return;
		}

		if (!rbt_admin.isSelected() && !rbt_lib.isSelected()) {
		    JOptionPane.showMessageDialog(null, "Please select a role!");
		    return;
		}
		
    	String pass = "";
    	
    	if(txt_pass.getText().equals(txt_com_pass.getText()))
    		pass = txt_pass.getText();
    	else 
    	{
    		JOptionPane.showMessageDialog(null, "Password no same error! you try again!");
    		txt_pass.clear();
    		txt_com_pass.clear();
    		return;
    	}
    	
    	LocalDate dob = dp_Dob.getValue();
    	
    	String g = "";
    	if(rbMale.isSelected()) 
    	{
    		g = "male";
    	}
    	if (rbFemale.isSelected()) 
    	{
    		g = "female";
    	}
    	String e = txt_email.getText();
    	String p = txt_phone.getText();
    
    	String r = "";
    	if (rbt_admin.isSelected()) 
    	{
    		r = "admin";
    	}
    	if (rbt_lib.isSelected()) 
    	{
    		r = "librariean";
    	}
    	String a = txt_address.getText();
    	
    	LocalDate j_date = dp_Join.getValue();
    	String img_f = "";
    	
    	if (img.getImage() != null) {
    	    img_f = img.getImage().getUrl();
    	}
    	System.out.println("Starting database registration...");
    	con = db.getDB();
    	pstmt = con.prepareStatement("INSERT INTO users (name, passwords,	date_of_birth,	gender,	email,	phone_no, role, address, join_date,	image) VALUES (?,?,?,?,?,?,?,?,?,?) ");
    	pstmt.setString(1, n);
    	pstmt.setString(2, pass);
    	pstmt.setDate(3, Date.valueOf(dob));
    	pstmt.setString(4, g);
    	pstmt.setString(5, e);
    	pstmt.setString(6, p);
    	pstmt.setString(7, r);
    	pstmt.setString(8, a);
    	pstmt.setDate(9, Date.valueOf(j_date));
    	pstmt.setString(10, img_f);
    	
    	result = pstmt.executeUpdate();
    	if(result > 0) 
    	{
    		JOptionPane.showMessageDialog(null, "Insert memeber done");
    	}
    	else 
    	{
    		JOptionPane.showMessageDialog(null, "something went wrong");
    	}
    	con.close();
    	ulist.clear();
    	ulist = get_user();
    	tbl_User.setItems(ulist);
	}
	public void update_user() throws SQLException, ClassNotFoundException 
	{
		String n = txt_name.getText();
    	
		String pass = "";
    	
    	if(txt_pass.getText().equals(txt_com_pass.getText()))
    		pass = txt_pass.getText();
    	else 
    	{
    		JOptionPane.showMessageDialog(null, "Password no same error! you try again!");
    		txt_pass.clear();
    		txt_com_pass.clear();
    		return;
    	}
    	
    	LocalDate dob = dp_Dob.getValue();
    	
    	String g = "";
    	if(rbMale.isSelected()) 
    	{
    		g = "male";
    	}
    	if (rbFemale.isSelected()) 
    	{
    		g = "female";
    	}
    	String e = txt_email.getText();
    	String p = txt_phone.getText();
    
    	String r = "";
    	if (rbt_admin.isSelected()) 
    	{
    		r = "admin";
    	}
    	if (rbt_lib.isSelected()) 
    	{
    		r = "librariean";
    	}
    	String a = txt_address.getText();
    	
    	LocalDate j_date = dp_Join.getValue();
    	String img_f = img.getImage().getUrl();
    	
    	con = db.getDB();
    	pstmt = con.prepareStatement("UPDATE users SET name = ?, passwords = ?, date_of_birth = ?, gender = ?, email = ?, phone_no = ?, role = ?, address = ?, join_date = ?, image = ? WHERE user_id = ?"
    		);

    		pstmt.setString(1, n);
    		pstmt.setString(2, pass);
    		pstmt.setDate(3, Date.valueOf(dob));
    		pstmt.setString(4, g);
    		pstmt.setString(5, e);
    		pstmt.setString(6, p);
    		pstmt.setString(7, r);
    		pstmt.setString(8, a);
    		pstmt.setDate(9, Date.valueOf(j_date));
    		pstmt.setString(10, img_f);

    		pstmt.setInt(11, u.getUser_id());

    		result = pstmt.executeUpdate();

    		if (result > 0) {
    		    JOptionPane.showMessageDialog(null, "Update member done");
    		}
    		
    	con.close();
    	ulist.clear();
    	ulist = get_user();
    	tbl_User.setItems(ulist);
	}
	public void delete_user() throws SQLException, ClassNotFoundException 
	{
		lbl_com_pass.setVisible(false);
		txt_com_pass.setVisible(false);
    	
		int id = name_to_id(txt_name.getText());
    	
    	con = db.getDB();
    	pstmt = con.prepareStatement("DELETE FROM users WHERE user_id = ?");

    		pstmt.setInt(1, id);

    		result = pstmt.executeUpdate();

    		if (result > 0) {
    		    JOptionPane.showMessageDialog(null, "Delete member done");
    		}
    		
    	con.close();
    	ulist.clear();
    	ulist = get_user();
    	tbl_User.setItems(ulist);
	}
	public String id_to_name(int id) throws ClassNotFoundException, SQLException 
	{
	    con = db.getDB();
	    pstmt = con.prepareStatement("SELECT name FROM users WHERE user_id = ?");
	    pstmt.setInt(1, id);
	    rs = pstmt.executeQuery();

	    String name = "";

	    if (rs.next())
	        name = rs.getString(1);

	    con.close();
	    return name;
	}

	public int name_to_id(String name) throws ClassNotFoundException, SQLException 
	{
		con = db.getDB();
		pstmt = con.prepareStatement("SELECT user_id FROM users WHERE name = ?");
		pstmt.setString(1,name);
		rs = pstmt.executeQuery();
		int id = 0;
		if(rs.next())
			id = rs.getInt(1);
		
		con.close();
		return id;
	}

}
