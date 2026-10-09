package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class member_controller implements Initializable {

	database_connection db = new database_connection();
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	ObservableList<member> mlist = FXCollections.observableArrayList();
	
    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_reg;

    @FXML
    private TableColumn<?, ?> col_address;

    @FXML
    private TableColumn<?, ?> col_book_count;

    @FXML
    private TableColumn<?, ?> col_dob;

    @FXML
    private TableColumn<?, ?> col_email;

    @FXML
    private TableColumn<?, ?> col_exp_date;

    @FXML
    private TableColumn<?, ?> col_gender;

    @FXML
    private TableColumn<?, ?> col_mid;

    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<?, ?> col_nrc;

    @FXML
    private TableColumn<?, ?> col_phone_no;

    @FXML
    private TableColumn<?, ?> col_reg_date;

    @FXML
    private DatePicker dp_dob;

    @FXML
    private DatePicker dp_exp_date;

    @FXML
    private DatePicker dp_reg_date;

    @FXML
    private RadioButton r_fmale;

    @FXML
    private RadioButton r_male;

    @FXML
    private TextArea txt_address;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_phone_no;
    
    @FXML
    private TextField txt_nrc;
    
    @FXML
    private TextField txt_search;
    
    @FXML
    private TableView<member> tbl_member;

    @FXML
    void click_clear(ActionEvent event) {

    }

    @FXML
    void click_enter(ActionEvent event) throws ClassNotFoundException, SQLException 
    {
    	String name = txt_search.getText();
    	
    	mlist.clear();
    	mlist = get_member( name );
    	tbl_member.setItems(mlist);
    }

    
    @FXML
    void click_reg(ActionEvent event) throws ClassNotFoundException, SQLException 
    {
    	String n = txt_name.getText();
    	
    	String nrc = txt_nrc.getText();
    	
    	LocalDate dob = dp_dob.getValue();
    	
    	String g = "";
    	if(r_male.isSelected()) 
    	{
    		g = "male";
    	}
    	if (r_fmale.isSelected()) 
    	{
    		g = "female";
    	}
    	String e = txt_email.getText();
    	String p = txt_phone_no.getText();
    	String a = txt_address.getText();
    	LocalDate r_date = dp_reg_date.getValue();
    	LocalDate e_date = dp_exp_date.getValue();
    	
    	con = db.getDB();
    	pstmt = con.prepareStatement("INSERT INTO member (name, nrc_no,	date_of_birth,	gender,	email,	phone_no, address,	register_date,	expired_date, book_count) VALUES (?,?,?,?,?,?,?,?,?,?) ");
    	pstmt.setString(1, n);
    	pstmt.setString(2, nrc);
    	pstmt.setDate(3, Date.valueOf(dob));
    	pstmt.setString(4, g);
    	pstmt.setString(5, e);
    	pstmt.setString(6, p);
    	pstmt.setString(7, a);
    	pstmt.setDate(8, Date.valueOf(r_date));
    	pstmt.setDate(9, Date.valueOf(e_date));
    	pstmt.setInt(10, 0);
    	
    	result = pstmt.executeUpdate();
    	if(result > 0) 
    	{
    		JOptionPane.showMessageDialog(null, "Insert memeber done");
    	}
    	con.close();
    	mlist.clear();
    	mlist = get_member();
    	tbl_member.setItems(mlist);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		col_mid.setCellValueFactory(new PropertyValueFactory<>("member_id"));

		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));

		col_nrc.setCellValueFactory(new PropertyValueFactory<>("nrc_no"));

		col_dob.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));

		col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

		col_email.setCellValueFactory(new PropertyValueFactory<>("email"));

		col_phone_no.setCellValueFactory(new PropertyValueFactory<>("phone_no"));

		col_address.setCellValueFactory(new PropertyValueFactory<>("address"));

		col_reg_date.setCellValueFactory(new PropertyValueFactory<>("register_date"));

		col_exp_date.setCellValueFactory(new PropertyValueFactory<>("expired_date"));

		col_book_count.setCellValueFactory(new PropertyValueFactory<>("book_count"));
		
		mlist.clear();
    	try {
			mlist = get_member();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	tbl_member.setItems(mlist);
		
		dp_reg_date.setValue(LocalDate.now());
		
		
		dp_exp_date.setValue(LocalDate.now().plusYears(1));
	}
	
	public ObservableList<member> get_member() throws SQLException, ClassNotFoundException
	{
		con = db.getDB();
		pstmt = con.prepareStatement("SELECT * FROM member");
		
		rs = pstmt.executeQuery();
		while(rs.next()) 
		{
			int mid = rs.getInt(1);
			String n = rs.getString(2);
			String nrc = rs.getString(3);
			LocalDate dob = rs.getDate(4).toLocalDate();
			String g = rs.getString(5);
			String e = rs.getString(6);
			String p = rs.getString(7);
			String a = rs.getString(8);
			LocalDate rdate = rs.getDate(9).toLocalDate();
			LocalDate edate = rs.getDate(10).toLocalDate();
			int b_count = rs.getInt(11);
			
			member m = new member(mid, n , nrc, dob, g, e, p, a, rdate, edate, b_count );
			
			mlist.add(m);
		}
		return mlist;
	}
	
	public ObservableList<member> get_member(String name) throws SQLException, ClassNotFoundException
	{
		con = db.getDB();
		pstmt = con.prepareStatement("SELECT * FROM member Where name = ?");
		
		pstmt.setString(1, name);
		
		rs = pstmt.executeQuery();
		while(rs.next()) 
		{
			int mid = rs.getInt(1);
			String n = rs.getString(2);
			String nrc = rs.getString(3);
			LocalDate dob = rs.getDate(4).toLocalDate();
			String g = rs.getString(5);
			String e = rs.getString(6);
			String p = rs.getString(7);
			String a = rs.getString(8);
			LocalDate rdate = rs.getDate(9).toLocalDate();
			LocalDate edate = rs.getDate(10).toLocalDate();
			int b_count = rs.getInt(11);
			
			member m = new member(mid, n , nrc, dob, g, e, p, a, rdate, edate, b_count  );
			
			mlist.add(m);
		}
		return mlist;
	}

}
