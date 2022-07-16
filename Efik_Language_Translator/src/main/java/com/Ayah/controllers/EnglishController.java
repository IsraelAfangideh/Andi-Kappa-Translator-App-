package com.Ayah.controllers;

import java.util.ArrayList;

import com.Ayah.daos.EnglishDAO;
import com.Ayah.models.english;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class EnglishController {

	
	EnglishDAO engDAO = new EnglishDAO();
	
	
	public Handler getAllEnglishWordsHandler = (ctx) -> {
	
		
		
		if(AuthController.ses != null) { //if the user is logged in, they can access this functionality
		
		//We need an ArrayList of English, courtesy of our EnglishDAO
		ArrayList<english> english = engDAO.getAllEnglishWords();
		
		
		Gson gson = new Gson();
		
		//use the GSON .toJson() method to turn our Java into JSON String (JSON is always in String format on the Java side)
		String JSONemployees = gson.toJson(english); //employees is the ArrayList of our employee data
		
		//use ctx to provide an HTTP response containing our JSON string of employees (which is what was requested)
		
		ctx.result(JSONemployees); //ctx.result() sends a response back (this is where our data goes)
		
		ctx.status(200); //ctx.status() sets the HTTP status code. 200 stands for "OK", the generic success code.
		
		} else { //if the user is NOT logged in (aka AuthController.ses wil be null)
			ctx.result("YOU ARE NOT LOGGED IN!! *SMACK*");
			ctx.status(401); //"forbidden" access code
		}
		
	}; //semicolon after curly brace? That's lambdas for you.

	
	
	public Handler insertEnglishWordsHandler = (ctx) -> {
		
		
		String body = ctx.body(); 
		
		
		Gson gson = new Gson();
		
		
		english newEng = gson.fromJson(body, english.class);
		
		
		if(engDAO.insertEnglishWord(newEng)) {
			//return a successful status code
			ctx.status(202); //202 stands for "accepted"
		} else {
			ctx.status(406); //406 stands for "Not Acceptable", AKA whatever the user sent couldn't be added to the DB
		}
		
	};
public Handler getThisEnglishWordHandler = (ctx) -> {
	
		
		
		if(AuthController.ses != null) { //if the user is logged in, they can access this functionality
		
		//We need an ArrayList of English, courtesy of our EnglishDAO
			
			String word = ctx.pathParam("word");
		 english english = engDAO.getThisEnglishWord(word);
		
		
		Gson gson = new Gson();
		
		
		String JSONemployees = gson.toJson(english); //employees is the ArrayList of our employee data
		
		
		
		ctx.result(JSONemployees);
		
		ctx.status(200); //ctx.status() sets the HTTP status code. 200 stands for "OK", the generic success code.
		
		} else { //if the user is NOT logged in (aka AuthController.ses wil be null)
			ctx.result("YOU ARE NOT LOGGED IN!");
			ctx.status(401); //"forbidden" access code
		}
		
	}; //semicolon after curly brace? That's lambdas for you.

}