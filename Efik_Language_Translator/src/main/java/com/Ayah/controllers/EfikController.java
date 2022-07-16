package com.Ayah.controllers;

import com.Ayah.daos.EfikDAO;
import com.Ayah.models.efik;
import com.Ayah.models.english;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class EfikController {
	
	EfikDAO efDAO = new EfikDAO();
	
	
public Handler deleteEfikWordHandler = (ctx) -> {
		

		int deleted = Integer.valueOf(ctx.pathParam("id"));
		
		efDAO.deleteEfikWord(deleted);
		
		ctx.result("Efik Word " + deleted + "has been deleted");
		ctx.status(200);
		
	};
	
	public Handler updateEfikForeignKeyHandler = (ctx) -> {
		
		//String to hold the role title (which comes in as a PATH PARAMETER)
		String word = ctx.pathParam("word"); //pathParam() gives us the value the user sends in as a path parameter
		//in this case, our Launcher endpoint handler calls it "title", so this is what we need to call here
		
		//int to hold the new Role salary, which the user will include in the BODY of the HTTP Request
		int efikfk = Integer.parseInt(ctx.body()); //we need to use parseInt here, because ctx.body() returns a String
		//in postman, no need to make a JSON object, we can just input whatever number we want.
		
		//if the update DAO method returns true (which means successful)..
		if (efDAO.updateEfikForeignKey(word, efikfk)) {
			ctx.status(202); //202 stands for "accepted"
			
		} else {
			ctx.status(406); //406 stands for "not acceptable"
		}
		
	};
public Handler insertEfikWordsHandler = (ctx) -> {
		
		
		String body = ctx.body(); 
		
		
		Gson gson = new Gson();
		
		
		efik newEfi = gson.fromJson(body, efik.class);
		
		
		if(efDAO.insertEfikWord(newEfi)) {
			//return a successful status code
			ctx.status(202); //202 stands for "accepted"
		} else {
			ctx.status(406); //406 stands for "Not Acceptable", AKA whatever the user sent couldn't be added to the DB
		}
		
	};
}


