
package com.cognizant.FinTech.Model;

public class User {

	String user_fullname;
	String user_Nid;
	String user_password;
	String user_role;
	boolean user_isactive;
	
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public String getUser_Nid() {
		return user_Nid;
	}
	public void setUser_Nid(String user_Nid) {
		this.user_Nid = user_Nid;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public boolean isUser_isactive() {
		return user_isactive;
	}
	public void setUser_isactive(boolean user_isactive) {
		this.user_isactive = user_isactive;
	}

	
}
