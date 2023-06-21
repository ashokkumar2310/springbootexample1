
package com.cognizant.FinTech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.FinTech.Dao.UserDao;
import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;

/**
 * this is the service method that connect UserDao and UserConroller
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	/**
	 * used to register a new user and the data from Dao and sent to controller
	 */

	@Override
	public boolean userSignUp(User user) {
		return userDao.userSignUp(user);
	}

	/**
	 * used to validate the login credentials of the userlogin data from Dao and
	 * sent to controller
	 */
	/*
	 * @Override public UserLogin validateUser(UserLogin login) { // TODO
	 * Auto-generated method stub return userDao.validateUser(login); }
	 *//**
		 * used to search for the bus from Dao and sent to controller
		 */

	/*
	 * @Override public List<Bus> searchbus(String from,String to) { // TODO
	 * Auto-generated method stub return userDao.searchbus(from,to); }
	 * 
	 *//**
		 * used to get all bus details from Dao and sent to controller
		 */

	@Override
	public List<Inventory> getAllApplication() { // TODO Auto-generated method stub
		return userDao.getAllApplication();
	}

	/**
	 * used to get bus details based on the id entered from Dao and sent to
	 * controller
	 */

  @Override 
  public Inventory getApplicationbyName(String Application_Name) { 
	  // TODO Auto-generated method

   return userDao.getApplicationbyName(Application_Name); 
   }

/**
 * used to book ticket in the bus based on the availability of the bus
 */
/*
 * @Override public boolean bookticket(UserSearch book) { // TODO Auto-generated
 * method stub return userDao.bookticket(book); }
 * 
 *//**
	 * used to get booking details based on the id entered from Dao and sent to
	 * controller
	 */
/*
 * @Override public UserSearch getbooking(String userid) { // TODO
 * Auto-generated method stub return userDao.getbooking(userid); }
 * 
 *//**
	 * used to get all the ticket booked details from Dao and sent to controller
	 */
/*
 * @Override public List<UserSearch> getAllbook() { // TODO Auto-generated
 * method stub return userDao.getallbook(); } 
 */}