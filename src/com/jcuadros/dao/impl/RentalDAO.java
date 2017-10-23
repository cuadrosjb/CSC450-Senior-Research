package com.jcuadros.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jcuadros.dbconn.MyConnection;
import com.jcuadros.pojo.Rental;
import com.jcuadros.pojo.RentalDAOI;

public class RentalDAO implements RentalDAOI{

	private final static String QUERY = "SELECT * FROM RENTAL"; 
	private List<Rental> rentals;
	
	public RentalDAO(){
		rentals = new ArrayList<Rental>();
	}
	
	@Override
	public List<Rental> getRentals() {

		Rental rental;
		ResultSet rs = null;
		Statement stm = null;
		Connection conn = null;
		
		try{
			conn = MyConnection.getConnection();
			
			stm = conn.createStatement();
			
			rs = stm.executeQuery(QUERY);
			
			while(rs.next()){
				rental = new Rental();
				rental.setCustomer_id(rs.getInt("customer_id"));
				rental.setInventory_id(rs.getInt("inventory_id"));
				rental.setLast_update(rs.getTimestamp("last_update"));
				rental.setRental_date(rs.getTime("rental_date"));
				rental.setRental_id(rs.getInt("rental_id"));
				rental.setReturn_date(rs.getTime("return_date"));
				rental.setStaff_id(rs.getInt("staff_id"));
				rentals.add(rental);
			}
			
		}catch (Exception e) {
			System.out.println("Error...!");
			
		}finally{
			try{
				rs.close();
				stm.close();
				conn.close();
			}catch (Exception e) {
				
			}
		}
		
		
		return rentals;
	}

	
	
	
}
