package model;

import java.io.Serializable;

public class User implements Serializable {
	private String user_id;
	private String user_name;
	private String password;
	private String role;

	public User() {}
	public User(String userId, String userName, String password) {
		this(userId, userName, password, "user");
	}
	public User(String userId, String userName, String password, String role) {
		this.user_id = userId;
		this.user_name = userName;
		this.password = password;
		this.role = role;
	}

	public String getId() {return user_id;}
	public String getName() {return user_name;}
	public String getPass() {return password;}
	public String getRole() {return role;}

	public void setId(String userId) {this.user_id = userId;}
	public void setName(String userName) {this.user_name = userName;}
	public void setPass(String password) {this.password = password;}
	public void setRole(String role) {this.role = role;}
}
