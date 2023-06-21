
package com.cognizant.FinTech.Service;

import java.util.List;

import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;

/**
 * this is interface for service method that connect UserDao and UserConroller
 */

public interface UserService {

	public boolean userSignUp(User user);
	public List<Inventory> getAllApplication();
	public Inventory getApplicationbyName(String Application_Name);
	
	/*
	 * public UserLogin validateUser(UserLogin login);
	 * 
	 * public List<Bus> searchbus(String from, String to);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public boolean bookticket(UserSearch book);
	 * 
	 * public UserSearch getbooking(String userid);
	 * 
	 * public List<UserSearch> getAllbook();
	 */
	// public boolean busBooking(Bus bus);

}
