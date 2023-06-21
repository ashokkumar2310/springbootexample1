
package com.cognizant.FinTech.Dao;

import java.util.List;

import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;

/**
 * this is interface for UserDaoImpl contains All necessary methods to signup ,
 * signin, search for bus, get all bus, getbusbyid, book ticket users
 *
 */

public interface UserDao {

	public boolean userSignUp(User user);
	public List<Inventory> getAllApplication();
	public Inventory getApplicationbyName(String Application_Name);

	/*
	 * public UserLogin validateUser(UserLogin login);
	 * 
	 * public List<Bus> searchbus(String from, String to);
	 * 
	 * // public boolean busBooking(Bus bus);
	 * 
	 * 
	 * 
	 * public boolean bookticket(UserSearch book);
	 * 
	 * public UserSearch getbooking(String userid);
	 * 
	 * public List<UserSearch> getallbook();
	 */

}
