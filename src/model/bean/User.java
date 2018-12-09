package model.bean;

public class User {
	private String name;
	private String username;
	private String password;
	private String address;
	private boolean isMan;
	
	public User(String name, String username, String password, String address, boolean isMan) {
		this.name = name;
		this.username = username;
		this.address = address;
		this.password = password;
		this.isMan = isMan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isMan() {
		return isMan;
	}

	public void setGender(boolean alive) {
		this.isMan = isMan;
	}

}
