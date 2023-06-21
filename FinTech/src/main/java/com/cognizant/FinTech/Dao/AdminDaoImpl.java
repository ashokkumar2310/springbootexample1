package com.cognizant.FinTech.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;

/**
 * In this class all the admin operations are performed
 */

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	JdbcTemplate template;

	@Override

	/**
	 * This function is used to addbus to the database
	 */

	public boolean AddApplication(Inventory inventory) {
		int up = 0;
		up = template.update("INSERT INTO Inventory VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", inventory.getApplication_Name(),
				inventory.getPoint_Of_Contact(), inventory.getIt_Owner(), inventory.getSME(),
				inventory.getBusiness_Usage(), inventory.getBusiness_Owner(), inventory.getProduction_Server(),
				inventory.getTest_Server(), inventory.getDev_Server(), inventory.getDB_Production_Server(),
				inventory.getDB_Test_Server(), inventory.getDB_Dev_Server());
		if (up == 0)
			return true;
		return true;
	}

	/**
	 * This function is used to get all the registered users
	 */

	@Override
	public List<User> getAllusers() {
		return template.query("select * from user", new ResultSetExtractor<List<User>>() {

			@Override
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<User> list = new ArrayList<User>();
				while (rs.next()) {
					User e = new User();

					e.setUser_fullname(rs.getString(1));
					e.setUser_Nid(rs.getString(2));
					e.setUser_password(rs.getString(3));
					e.setUser_role(rs.getString(4));
					e.setUser_isactive(rs.getBoolean(5));
					list.add(e);
				}
				return list;
			}

		});

	}

	@Override
	public List<Inventory> getAllApplication() {
		return template.query("select * from Inventory", new ResultSetExtractor<List<Inventory>>() {
			@Override
			public List<Inventory> extractData(ResultSet rs) throws SQLException, DataAccessException {

				ArrayList<Inventory> list = new ArrayList<Inventory>();
				while (rs.next()) {
					Inventory e = new Inventory();
					e.setApplication_Name(rs.getString(1));
					e.setPoint_Of_Contact(rs.getString(2));
					e.setBusiness_Usage(rs.getString(5));
					e.setSME(rs.getString(4));
					e.setIt_Owner(rs.getString(3));
					e.setBusiness_Owner(rs.getString(6));
					e.setProduction_Server(rs.getString(7));
					e.setTest_Server(rs.getString(8));
					e.setDev_Server(rs.getString(9));
					e.setDB_Production_Server(rs.getString(10));
					e.setDB_Test_Server(rs.getString(11));
					e.setDB_Dev_Server(rs.getString(12));
					list.add(e);
				}
				for (Inventory intt : list)
					System.out.println(intt);
				return list;
			}

		});
	}

	/**
	 * this function is used to update bus details for the selected busid
	 * 
	 * @return updated else @return exception
	 */
	@Override
	public String updateApplication(String Application_Name, Inventory inventory) {
		Inventory us = template.query(
				"SELECT * FROM inventory WHERE Application_Name =" + "\"" + Application_Name + "\"",
				new ResultSetExtractor<Inventory>() {

					@Override
					public Inventory extractData(ResultSet rs) throws SQLException, DataAccessException {
						Inventory us = new Inventory();
						while (rs.next()) {
							us.setApplication_Name(Application_Name);
							us.setPoint_Of_Contact(rs.getString(2));
							us.setIt_Owner(rs.getString(3));
							us.setSME(rs.getString(4));
							us.setBusiness_Usage(rs.getString(5));
							us.setBusiness_Owner(rs.getString(6));
							us.setProduction_Server(rs.getString(7));
							us.setTest_Server(rs.getString(8));
							us.setDev_Server(rs.getString(9));
							us.setDB_Production_Server(rs.getString(10));
							us.setDB_Test_Server(rs.getString(11));
							us.setDB_Dev_Server(rs.getString(12));

							return us;
						}
						return null;
					}
				});
		if (us == null)
			return "notfound";
		int update = 0;
		update = template.update(
				"UPDATE Inventory SET Point_Of_Contact=?,It_Owner=?,SME=?, Business_Usage=?, Business_Owner=?, Production_Server=?,Test_Server=?,Dev_Server=?,DB_Production_Server=?,DB_Test_Server=?,DB_Dev_Server=? WHERE Application_Name=?",
				inventory.getPoint_Of_Contact(), inventory.getIt_Owner(), inventory.getSME(),
				inventory.getBusiness_Usage(), inventory.getBusiness_Owner(), inventory.getProduction_Server(),
				inventory.getTest_Server(), inventory.getDev_Server(), inventory.getDB_Production_Server(),
				inventory.getDB_Test_Server(), inventory.getDB_Dev_Server(), Application_Name);
		if (update == 0)
			return "error";
		return "updated";
	}

	/**
	 * this function delete the bus based on the bus id given
	 * 
	 * @return true else @return false
	 */

	@Override
	public boolean deleteApplication(String Application_Name) {
		int update = 0;
		update = template.update("DELETE FROM Inventory WHERE Application_Name= ?", Application_Name);
		if (update == 0)
			return false;
		return true;
	}

	/**
	 * this function checks if admin credentials present in database
	 * 
	 * @return usr else @return null throws error
	 */

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Override public AdminLogin validateAdmin(AdminLogin login) { AdminLogin usr
	 * = null; try { String sql =
	 * "select * from adminlogin where username= ? and password=?"; usr =
	 * template.queryForObject(sql, new Object[] { login.getUsername(),
	 * login.getPassword() }, new UserMapper());
	 * 
	 * } catch (EmptyResultDataAccessException exception) { usr = null; } return
	 * usr; }
	 */

	/**
	 * This method is used to get the user details based on the entered email-id
	 * 
	 * @return usr else
	 * @return null
	 */

	@Override
	public Inventory getApplicationByName(String Application_Name) {
		List<Inventory> list = getAllApplication();
		for (Inventory inv : list) {

			if (inv.getApplication_Name().equals(Application_Name)) {
				return inv;
			}
		}
		return null;
	}

	/**
	 * this function checks if admin credentials present in database if not throws
	 * error
	 */
	@Override
	public String updatepassword(String Id, User user) {
		int update = 0;
		update = template.update("UPDATE user SET  user_password=?,user_fullname=?,user_role=?,user_isactive=? WHERE user_Nid=?", user.getUser_password(),user.getUser_fullname(),user.getUser_role(),user.isUser_isactive(), Id);
		update = template.update("UPDATE credentials SET password=? WHERE username=?", user.getUser_password(), Id);
		if (update == 0)
			return "error";
		return "updated";
	}

	@Override
	public User getUserById(String id) {
		List<User> list = getAllusers();
		for (User inv : list) {

			if (inv.getUser_Nid().equals(id)) {
				return inv;
			}
		}
		return null;
	}

}
