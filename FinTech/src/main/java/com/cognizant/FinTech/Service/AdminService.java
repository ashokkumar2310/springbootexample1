package com.cognizant.FinTech.Service;

import java.util.List;

import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;


/**
 *this is  interface for service method that
 *connect AdminDao and AdminConroller
 */

public interface AdminService {

	public boolean AddApplication(Inventory inventory);

	public List<Inventory> getAllApplication();

	/*
	 * 
	 * 
	 * 
	 * public String updatebus(String id, Inventory bus);
	 *public AdminLogin validateAdmin(AdminLogin login); 
	 * 
	 */
	public List<User> getAllusers();
	public boolean deleteApplication(String Application_Name);
	
	public Inventory getApplicationByName(String Application_Name);
	public String updateApplication(String Application_Name, Inventory inventory);
	/*
	 * public User getApplicationByName(String emailId);
	 * 
	 * public String updatePassword(String emailId, User user);
	 */

	public User getUserById(String id);

	public String updatePassword(String id, User user);

	

	
	
}
