package com.cognizant.FinTech.Dao;

import java.util.List;


import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;


public interface AdminDao {

	public boolean AddApplication(Inventory inventory);

	public List<Inventory> getAllApplication();
	
	public Inventory getApplicationByName(String Application_Name);
	public String updateApplication(String Application_Name, Inventory inventory);
	public boolean deleteApplication(String Application_Name);
	public List<User> getAllusers();
	/*
	 * 
	 * 
	 * public String updatebus(String id, Bus bus);
	 * 
	 * 
	 * public AdminLogin validateAdmin(AdminLogin login);
	 * 
	 * 
	 * public User getUserbyId(String emailId);
	 * 
	 * public String updatepassword(String emailId, User user);
	 */

	public User getUserById(String id);

	public String updatepassword(String emailId, User user);
	
}
