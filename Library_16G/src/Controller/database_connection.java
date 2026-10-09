package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_connection 
{
	public Connection getDB() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/library_management _system_db";
		Connection con = DriverManager.getConnection(url, "root", "");
		
		return con;
	}
}
