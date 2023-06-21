package com.cognizant.FinTech.Model;

/**
 * this is model class admin
 */

public class AdminLogin {

	String username;
	String password;

	/**
	 * @param getAdminusername
	 * @return adminusername
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param adminusername
	 * used to setAdminname
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param getAdminpassword
	 * @return adminpassword
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param adminpassword
	 * used to setAdminpassword
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

}
