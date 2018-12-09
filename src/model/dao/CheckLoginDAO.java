package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.User;

public class CheckLoginDAO {
	
	private static ArrayList<User> Users = new ArrayList<User>();
	
	public CheckLoginDAO() {
		 try {
			getUserFromDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isExistUser(String userName, String password) {
		
		for(int i=0;i<Users.size();i++) {
			User user = Users.get(i);
			if(user.getUsername().equals(userName) && user.getPassword().equals(password)) {
				return true;
			}
		}	
		return false;
	}

	public User getUser(String userName) {
		User user;
		for(int i=0;i<Users.size();i++) {
			user = Users.get(i);
			if(user.getUsername().equals(userName)) {
				return user;
			}
		}	
		return null;
	}
	
	public static void getUserFromDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-D9J383E\\\\SQLEXPRESS:1433;DatabaseName=Users","sa","sa");
		Statement stmt =  conn.createStatement();
		
		String query = "Select Username,Password, Name, Address,Gender from Acc";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			String username = rs.getString("Username");
			String password = rs.getString("Password");
			String name = rs.getString("Name");
			String address = rs.getString("Address");
			Boolean gender = rs.getBoolean("Gender");
			
			Users.add(new User(name,username,password,address,gender));
		}
	}
	
}
