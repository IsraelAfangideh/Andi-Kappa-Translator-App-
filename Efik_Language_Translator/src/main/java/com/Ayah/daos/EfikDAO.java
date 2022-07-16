package com.Ayah.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Ayah.models.efik;
import com.Ayah.models.english;
import com.Ayah.util.Connectionsutil;

public class EfikDAO implements EfikDAOInterface {


	@Override
	public efik getEfikWordById(int efik_id) {
		
		//use a try-with-resources to open a DB connection object
		try(Connection con = Connectionsutil.getConnection()){
			
			
			String sql = "select * from efik where efik_id = ?;";
			
			//we need a PreparedStatment object to fill in the variable above with setInt().
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setInt(1, efik_id); 
			
			
			ResultSet rs = ps.executeQuery(); 
			
			
			while(rs.next()) {
				
				
				efik efi = new efik(
						rs.getInt("efik_id"),
						rs.getString("efik_word"),
						rs.getInt("english_id_fk")
					); 
				
				return efi;	
			}
			
		} catch (SQLException e) {
			System.out.println("Get Efik Word failed"); 
			e.printStackTrace(); 
		}
		
		return null;
		
	} 
	
	@Override
	public void deleteEfikWord(int id) {
		
		try(Connection con = Connectionsutil.getConnection()){
			
			//SQL String that we want to send to the DB
			String sql = "delete from efik where efik_id = ?;";
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			
			ps.executeUpdate();
			
			
			System.out.println(id + "has been removed from dictionary");
			
		} catch (SQLException e) {
			System.out.println("delete was unsuccessful, please try again");
			e.printStackTrace();
		}
	}
		
		@Override
		public  boolean updateEfikForeignKey (String efik_word, int english_id_fk) {
			
			try(Connection con = Connectionsutil.getConnection()){
				
				//SQL String for our UPDATE command
				String sql = "update efik set english_id_fk = ? where efik_word = ?;";
				
				//create our PreparedStatement to fill in the variables
				PreparedStatement ps = con.prepareStatement(sql);
				
				//input the appropriate values into our PreparedStatement
				ps.setInt(1, english_id_fk);
				ps.setString(2, efik_word);
				
				//execute the update!
				ps.executeUpdate();
				
				//tell the console the update was successfully 
				System.out.println(efik_word + " has been updated to the enlish word matching english_id: " + english_id_fk);
				
				//if it succeeds, return true
				return true;
				
			} catch (SQLException e) {
				System.out.println("FAILED TO UPDATE TRANSLATOR");
				e.printStackTrace();
			}
			
			
			return false; //if update fails, return false
			
		}

		@Override
		public boolean insertEfikWord(efik efik) {
			try(Connection con = Connectionsutil.getConnection()){
				
				
				String sql = "insert into efik (efik_id, efik_word, english_id_fk) values (?, ?, ?);";
					
				
				PreparedStatement ps = con.prepareStatement(sql);
					
				
				ps.setInt(1, efik.getEfik_id());
				ps.setString(2, efik.getEfik_word());
				ps.setInt(3, efik.getEnglish_id_fk());
				
				System.out.println(ps);
				
				
				ps.executeUpdate(); 
				
				
				System.out.println(efik.getEfik_word() + " was added successfully");
				
				return true;
					
				} catch (SQLException e) {
					System.out.println("Failed to add word, try again"); 
					e.printStackTrace();
				}
				
				return false;
			} 

	
		
}

