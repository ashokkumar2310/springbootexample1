
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
 * This UserDaoImpl is used to perform user side operation from the database
 *
 */

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate template;

	/**
	 * This method is for new user registration where the entered details are stored
	 * in the database
	 * 
	 * @return true if registered successfully else @return false
	 */

	@Override
	public boolean userSignUp(User user) {
		int up = 0;
		up = template.update("INSERT INTO user VALUES (?,?,?,?,?)", user.getUser_fullname(),user.getUser_Nid(),user.getUser_password(),user.getUser_role(),user.isUser_isactive());
		template.update("INSERT INTO credentials VALUES(?,?)", user.getUser_Nid(), user.getUser_password());
		if (up == 0)
			return false;
		return true;
	}

	/**
	 * This method is used to check whether the user entered the correct user side
	 * credentials
	 * 
	 * @return usr else
	 * @return null
	 */
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Override public UserLogin validateUser(UserLogin login) { UserLogin
	 * usr=null; try { String sql =
	 * "select * from userlogin where username= ? and password=?"; usr=
	 * template.queryForObject(sql, new Object[] {
	 * login.getUsername(),login.getPassword() }, new UserMapperUser());
	 * 
	 * } catch(EmptyResultDataAccessException exception) { usr=null; } return usr; }
	 * 
	 *//**
		 * This method is used to search for the bus based on the from and to
		 * destination
		 * 
		 * @return buslist
		 */

	/*
	 * 
	 * @Override public List<Bus> searchbus(String from,String to) { List<Bus> list
	 * = getAllbus(); List<Bus> list1= new ArrayList<Bus>();
	 * 
	 * for (Bus bus : list) {
	 * 
	 * if (bus.getFrom().equals(from) && bus.getTo().equals(to)) { list1.add(bus); }
	 * }
	 * 
	 * 
	 * return list1; }
	 * 
	 * 
	 *//**
		 * This method is used to get all the bus that are registered in the database
		 * 
		 * @return buslist
		 */

	@Override
	public List<Inventory> getAllApplication() {
		return template.query("select * from inventory", new ResultSetExtractor<List<Inventory>>() {

			@Override
			public List<Inventory> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Inventory> list = new ArrayList<Inventory>();
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
				return list;
			}

		});
	}

	/**
	 * This method is used to get the bus details based on the entered bus number
	 * 
	 * @return usr else
	 * @return null
	 */

	@Override
	public Inventory getApplicationbyName(String Application_Name) {
		List<Inventory> list = getAllApplication();
		for (Inventory usr : list) {

			if (usr.getApplication_Name().equals(Application_Name)) {
				return usr;
			}
		}
		return null;
	}

	/**
	 * This method is used to store the booked details in the mysql database
	 * 
	 * @return true else
	 * @return false
	 */
	/*
	 * @Override public boolean bookticket(UserSearch book) { int up = 0; up =
	 * template.
	 * update("INSERT INTO bookings(busno,userid,start_location,end_location,start,end,bustype,fare) VALUES (?,?,?,?,?,?,?,?)"
	 * ,book.getBusno(),book.getUserId(),book.getFrom(),book.getTo(),book.
	 * getStarttime(),book.getEndtime(),book.getBustype(),book.getFare());
	 * 
	 * if (up == 0) return false; return true; }
	 * 
	 *//**
		 * Here after confirmation of the ticket the user able to get the booking
		 * details @return usr else
		 * 
		 * @return null
		 */
	/*
	 * @Override public UserSearch getbooking(String userid) { List<UserSearch> list
	 * = getallbook(); for (UserSearch usr : list) {
	 * 
	 * if(usr.getUserId().equals(userid)) { return usr; } } return null; }
	 * 
	 *//**
		 * This method is used to get all the bookings done by the user
		 * 
		 * @return booking_list
		 *//*
			 * @Override public List<UserSearch> getallbook() { return
			 * template.query("select * from bookings", new
			 * ResultSetExtractor<List<UserSearch>>() {
			 * 
			 * @Override public List<UserSearch> extractData(ResultSet rs) throws
			 * SQLException, DataAccessException {
			 * 
			 * List<UserSearch> list = new ArrayList<UserSearch>(); while (rs.next()) {
			 * UserSearch e = new UserSearch(); e.setBusno(rs.getString(2));
			 * e.setUserId(rs.getString(3)); e.setFrom(rs.getString(4));
			 * e.setTo(rs.getString(5)); e.setStarttime(rs.getString(6));
			 * e.setEndtime(rs.getString(7)); e.setBustype(rs.getString(8));
			 * e.setFare(rs.getInt(9)); list.add(e); } return list; }
			 * 
			 * }); }
			 */
}