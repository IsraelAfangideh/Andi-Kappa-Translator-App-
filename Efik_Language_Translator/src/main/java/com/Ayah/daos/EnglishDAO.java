package com.Ayah.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Ayah.models.efik;
import com.Ayah.models.english;
import com.Ayah.util.Connectionsutil;

//SELECT * FROM english INNER JOIN efik ON efik.english_id_fk = english.english_id WHERE english_word = 'Abandon';
public class EnglishDAO implements EnglishDAOInterface {
	
	


	@Override
	public boolean insertEnglishWord(english english) {
		
		
		try(Connection con = Connectionsutil.getConnection()){
			
		
		String sql = "insert into english (english_id, english_word) values (?, ?);";
			
		
		PreparedStatement ps = con.prepareStatement(sql);
			
		
		ps.setInt(1, english.getEnglish_id());
		ps.setString(2, english.getEnglish_word());
		
		System.out.println(ps);
		
		
		ps.executeUpdate(); 
		
		
		System.out.println(english.getEnglish_word() + " was added!");
		
		return true;
			
		} catch (SQLException e) {
			System.out.println("Failed to add word, try again"); 
			e.printStackTrace();
		}
		
		return false;
	} 

	
	
	@Override
	public ArrayList<english> getAllEnglishWords() {
		
		try(Connection conn = Connectionsutil.getConnection()){
			
			
			String sql = "select * from english full outer join efik on english_id_fk = english_id;";
			
			
			Statement s = conn.createStatement(); 
		
			ResultSet rs = s.executeQuery(sql);
			
			//Instantiate an empty ArrayList to hold our Employee data (remember, java can't read SQL).
			ArrayList<english> english = new ArrayList<>();
			
			//use rs.next() in a while loop to create Employee object and populate our ArrayList with them.
			while(rs.next()) { //rememeber, rs.next() returns "true" if there are more results that we haven't looked at yet
				
				//Create a new Employee object from each record in the ResultSet
				//we're using the all-args constructor!!
				english eng = new english(
							rs.getInt("english_id"),
							rs.getString("english_word"),
							null //there is no JDBC method for getRole()... we'll add the Role object below 
							//this is an extra step we have to take, because in the DB, role_id_fk is an int
							//but we need a Role object here... not an int
						);
						
				//we need to get a Role object somehow
				//we need to use the RoleDAO method to get a role by ID.
				int efikid = rs.getInt("efik_id");
				
				//Instantiate a RoleDAO so we can use getRoleById
				EfikDAO eDAO = new EfikDAO();
				
				//get a efik object using the int that we populate with rs.getInt()!!!!
				efik ef = eDAO.getEfikWordById(efikid);
				
				//use the SETTER of our Employee class to set the Role object to the one we got from the DB
				eng.setEfik(ef);
				//thanks to this setter, we have a FULLY INITIALIZED Employee object
				
				//add the new Employee to our ArrayList. For every employee returned, we put it in the ArrayList
				english.add(eng); 
				
			} //end of while loop
			
			//once the while loop breaks (once rs.next() == false), return the ArrayList
			return english;
			
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING THIS WORD"); //tell the console it failed
			e.printStackTrace(); //print the error log for debugging
		}
		
		return null; //so the compiler doesn't complain when our REAL return is in a try block
		
	} //end of get all 
	
	@Override
	 public  english getThisEnglishWord(String english_word) {
		 {
				
				try(Connection conn = Connectionsutil.getConnection()){
					
					
					String sql = "select * from english full outer join efik on english_id_fk = english_id where english_word = ?;";
					
					
					PreparedStatement ps = conn.prepareStatement(sql); 
					
					ps.setString(1, english_word);
				
					ResultSet rs = ps.executeQuery();
					
					//Instantiate an empty ArrayList to hold our Employee data (remember, java can't read SQL).
					ArrayList<english> english = new ArrayList<>();
					ArrayList <String> efi = new ArrayList <> ();
					//use rs.next() in a while loop to create Employee object and populate our ArrayList with them.
					english eng = new english();
					
					while(rs.next()) {
							int engint = 	rs.getInt("english_id");
							String engString =	rs.getString("english_word");
									
								
						//we need to get a Role object somehow
						//we need to use the RoleDAO method to get a role by ID.
						int efikid = rs.getInt("efik_id");
						
						//Instantiate a RoleDAO so we can use getRoleById
						EfikDAO eDAO = new EfikDAO();
						
						//get a efik object using the int that we populate with rs.getInt()!!!!
						efik ef = eDAO.getEfikWordById(efikid);
						
					
						
						efi.add(ef.getEfik_word());
						//use the SETTER of our Employee class to set the Role object to the one we got from the DB
					
					
						//thanks to this setter, we have a FULLY INITIALIZED Employee object
						
						//add the new Employee to our ArrayList. For every employee returned, we put it in the ArrayList
						english.add(eng); 
						eng.setEnglish_id(engint);
						eng.setEnglish_word(engString);
						
					}
					eng.setTranslations(efi);//end of while loop
					
					//once the while loop breaks (once rs.next() == false), return the ArrayList
					return eng;
					
				} catch (SQLException e) {
					System.out.println("SOMETHING WENT WRONG GETTING THIS WORD"); //tell the console it failed
					e.printStackTrace(); //print the error log for debugging
				}
				
				return null; //so the compiler doesn't complain when our REAL return is in a try block
				
			} //end of get all 
		 
	 }
}
