package com.cognizant.FinTech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.FinTech.Dao.AdminDao;
import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	
	@Override
	public boolean AddApplication(Inventory inventory) {
		return adminDao.AddApplication(inventory);
	}

	
	@Override
	public List<User> getAllusers() {
		// TODO Auto-generated method stub
		return adminDao.getAllusers();
	}

	
	@Override
	public List<Inventory> getAllApplication() {
		// TODO Auto-generated method stub
		return adminDao.getAllApplication();
	}

	
	@Override
	public String updateApplication(String Application_Name, Inventory inventory) {
		// TODO Auto-generated method stub
		return adminDao.updateApplication(Application_Name,inventory);
	}

	/**
	 * used to delete the registered 
	 * bus details with the id entered in the  
	 * admin side with Daolayer
	 */
	@Override
	public boolean deleteApplication(String Application_Name) {
		// TODO Auto-generated method stub
		return adminDao.deleteApplication(Application_Name);
	}

	/**
	 * used to validate
	 * admin details with Daolayer
	 */
	/*
	 * @Override public AdminLogin validateAdmin(AdminLogin login) { // TODO
	 * Auto-generated method stub return adminDao.validateAdmin(login); }
	 */

	/**
	 * used to get the registered 
	 * user details by entering 
	 * the email-id 
	 * admin side with Daolayer
	 */
	@Override
	public Inventory getApplicationByName(String Application_Name) {
		return adminDao.getApplicationByName(Application_Name);
	}
	
	@Override
	public User getUserById(String id) {
		return adminDao.getUserById(id);
	}

	/**
	 * used to update the password of the 
	 * registered user based on 
	 * the mail-id entered
	 */
	@Override
	public String updatePassword(String emailId, User user) {
		// TODO Auto-generated method stub
		return adminDao.updatepassword(emailId, user);
	}
//	
}
