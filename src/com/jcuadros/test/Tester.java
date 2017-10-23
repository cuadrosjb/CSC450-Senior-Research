package com.jcuadros.test;

import java.util.ArrayList;
import java.util.List;

import com.jcuadros.dao.impl.RentalDAO;
import com.jcuadros.pojo.Rental;
import com.jcuadros.pojo.RentalDAOI;

public class Tester {

	public static void main(String[] args) {
		
		RentalDAOI rental = new RentalDAO();
		List<Rental> lst = new ArrayList<Rental>();
		System.out.println(System.currentTimeMillis());
		lst.addAll(rental.getRentals());
		System.out.println(System.currentTimeMillis());
		
		System.out.println(lst.get(0).toString());
		
		

	}

}
