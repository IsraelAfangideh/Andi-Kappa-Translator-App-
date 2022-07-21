package com.Ayah.controllers;

import javax.servlet.http.HttpSession;

import com.Ayah.models.LoginDTO;
import com.Ayah.models.users;
import com.Ayay.services.AuthService;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class AuthController {

	//we need an AuthService, remember the Service layer sits between the Controllers and DAOs
	AuthService as = new AuthService();
	
	//empty HttpSession object that will be filled upon successful login
	public static HttpSession ses;
	
	//we need a loginHandler to take in Login Data, make a LoginDTO, and send it to the service
	//if login is successful, the service sends back a String which we use in our return (ctx.result())
	//we test whether the login service method returns null or a String 
	//also, a Session will be created when the user logs in successfully.
	
	//login will be a POST request, check insertEmployeeHandler if any of this syntax eludes you
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		
		users user = as.login(lDTO.getUsername(), lDTO.getPassword()); //this will either be a String or Null.
		
		if(user != null) { //if login is successful...
			
			ses = ctx.req.getSession(); //this is how we create new sessions
			
			String userJSON = gson.toJson(user);
			ctx.result(userJSON);
			ctx.status(202); //202 stands for "accepted"
			
		} else {
			ctx.status(401); //401 stands for "unauthorized"
		}
		
	};
}
	