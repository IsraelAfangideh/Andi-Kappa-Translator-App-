package com.Ayah.models;
//A user class almost defeats the purpose of a login DTO, but we still need a DTO
//for when we want to access ONLY the username and password. 
public class users {
	
	public int user_id;
	public String username;
	public String password;
	
	
	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
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


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

//All args minus ID
	public users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public users(int user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}
	
	

}
