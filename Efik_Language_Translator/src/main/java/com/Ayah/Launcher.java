package com.Ayah;

import java.sql.Connection;
import java.sql.SQLException;

import com.Ayah.controllers.AuthController;
import com.Ayah.controllers.EfikController;
import com.Ayah.controllers.EnglishController;
import com.Ayah.daos.EfikDAO;
import com.Ayah.daos.EnglishDAO;
import com.Ayah.util.Connectionsutil;

import io.javalin.Javalin;

public class Launcher {

	
		
		
		public static void main(String[] args) {
			
			//****These aren't being used anymore, DAO methods are now called in the Controller layer
			//Instantiate an EmployeeDAO and RoleDAO so we can use their methods
			EnglishDAO engDAO = new EnglishDAO();
			EfikDAO efiDAO = new EfikDAO();
			
			
			System.out.println("========Hello, I am Andi-Kappa! The first Efik/Ibibio Translator========");
			
			//this is a try-with-resources block. it will test whether our Connection works.
			//try-with-resources works by trying to open a certain resource (Connection in this case)
			//and catch an exception if the resource fails to open. 
			//So in this case, if we fail to open a connection, it will throw an exception
			try(Connection conn = Connectionsutil.getConnection()){
				System.out.println("CONNECTION SUCCESSFUL :)");
			} catch (SQLException e) {
				//if the connection fails to open, catch the resulting SQLException and print the stack trace (error log)
				System.out.println("connection failed...");
				e.printStackTrace();
			} //end of the connection test
				
			
			//Typical Javalin syntax to CREATE a javalin object 
			Javalin app = Javalin.create(
					
					//the config lambda lets us specify certain configurations for our Javalin app.
					config -> {
						config.enableCorsForAllOrigins(); //this lets us process HTTP requests from any origin
					}
					
					).start(5000); 
		
			
			EnglishController ec = new EnglishController();
			
			
			EfikController ef = new EfikController();
			
			EnglishDAO eDAO = new EnglishDAO ();
			AuthController ac = new AuthController();
			
			app.post("/login", ac.loginHandler);
			
			app.get("/english", ec.getAllEnglishWordsHandler);
			
			app.get("/english/:word", ec.getThisEnglishWordHandler);
			
			app.put("/efik/:word", ef.updateEfikForeignKeyHandler);
			
			app.post("/english", ec.insertEnglishWordsHandler);
			
			app.delete("/delete/:id", ef.deleteEfikWordHandler);
			
			//app.post("/efik", ef.insertEfikWordsHandler);
			
			//System.out.println(eDAO.getAllEnglishWords());
			
						
			//efik/delete
			
			
			
		
			
			
		} //end of main
	}
