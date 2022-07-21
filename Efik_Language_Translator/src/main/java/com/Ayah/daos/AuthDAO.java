package com.Ayah.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Ayah.models.users;
import com.Ayah.util.Connectionsutil;

public class AuthDAO {

	//I should've made an Interface but it's ok.
	
	//This DAO would likely have other methods like register user, or update user info
	//but we just need a login for P0 and P1.
	
	public users login(String username, String password) {
		
		try(Connection conn = Connectionsutil.getConnection()){
			
		String sql = "select * from users where username = ? and password = ?;";
			
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		//if anything gets returned at all, we know a user exists with that username/password pair. so we can return true
		
		//Create a user object to send to the front end
		if(rs.next()) {
			
			users u = new users (
					
					rs.getString("username"),
					rs.getString("password")
					
					);
					return u;
		}
			
		} catch (SQLException e) {
			System.out.println("LOGIN FAILED");
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	
}
