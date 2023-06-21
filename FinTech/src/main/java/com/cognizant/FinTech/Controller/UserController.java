
package com.cognizant.FinTech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;
import com.cognizant.FinTech.Service.UserService;

/**
 * this class helps user to signup, update password, search for bus, payment and
 * view ticket details
 */

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * @param user this function is used By the user where he can validate his login
	 *             credentials
	 * @return OK else
	 * @return exception
	 */

	/*
	 * @PostMapping("/userlogin") public UserLogin validateUser(@RequestBody
	 * UserLogin login) { UserLogin usr= userService.validateUser(login);
	 * if(usr==null) { throw new ResourceNotFoundException("Invalid User");
	 * 
	 * } return usr; }
	 */
	/**
	 * @param user this function is used By the user where he register for the first
	 *             time
	 * @return created
	 */

	@PostMapping("/newuser")
	public ResponseEntity<Object> UserSignUp(@RequestBody User user) {
		boolean signUp = userService.userSignUp(user);
		if (signUp)
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param user this function is used By the user where he search for the from
	 *             and to locations
	 * @return bus available for the selected destination
	 */

	/*
	 * @GetMapping("/searchbus/{fromlocation}/{tolocation}") public
	 * ResponseEntity<Object> searchbus(@PathVariable("fromlocation") String
	 * fromlocation,@PathVariable("tolocation") String tolocation){
	 * 
	 * return new ResponseEntity<>(userService.searchbus(fromlocation,tolocation),
	 * HttpStatus.OK);
	 * 
	 * }
	 */
	/**
	 * @param user this function is used by the user where the user can see all the
	 *             bus available in the page to travel
	 * @return bus available for journey
	 */

	@GetMapping("/allApplication")
	public ResponseEntity<Object> getAllApplication() {
		return new ResponseEntity<>(userService.getAllApplication(), HttpStatus.OK);
	}

	@GetMapping("/allApplication/{Application_Name}") 
  public ResponseEntity<Object>getApplicationbyName(@PathVariable("Application_Name") String Application_Name){ 
		Inventory inv = userService.getApplicationbyName(Application_Name);
		if(inv!=null) 
			return new ResponseEntity<>(inv,HttpStatus.OK); 
		return new ResponseEntity<>("Searched Data Not Found",HttpStatus.NOT_FOUND); 
		}

/**
 * @param user this function is used by the user to book the ticket for his
 *             journey
 * @return bus available for journey
 */

/*
 * @PostMapping("/book") public ResponseEntity<Object> booking(@RequestBody
 * UserSearch book) { boolean bo = userService.bookticket(book); if (bo) return
 * new ResponseEntity<>(book, HttpStatus.CREATED); return new
 * ResponseEntity<>(HttpStatus.BAD_REQUEST); }
 */
/**
 * This method is used to get all the booking by the user
 */

/*
 * @GetMapping("/book") public ResponseEntity<Object> getAllbook(){ return new
 * ResponseEntity<>(userService.getAllbook(), HttpStatus.OK); }
 */
/**
 * This method is used to get the booking based on the entered user-id
 */
/*
 * @GetMapping("/book/{userid}") public ResponseEntity<Object>
 * getbooking(@PathVariable("userid") String userid){ UserSearch book =
 * userService.getbooking(userid); if(book!=null) return new
 * ResponseEntity<>(book, HttpStatus.OK); return new
 * ResponseEntity<>("Searched Data Not Found", HttpStatus.NOT_FOUND); } 
 */
}