package com.cognizant.FinTech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Model.User;
import com.cognizant.FinTech.Service.AdminService;

/*
This is controller class which helps admin
to login into the web application and perform
actions
*/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/Admin/allApplication")
	public ResponseEntity<Object> getAllApplication() {
		return new ResponseEntity<>(adminService.getAllApplication(), HttpStatus.OK);
	}

	@PostMapping("/Admin/addapplication")
	public ResponseEntity<Object> AddApplication(@RequestBody Inventory inventory) {
		boolean add = adminService.AddApplication(inventory);
		if (add)
			return new ResponseEntity<>(inventory, HttpStatus.CREATED);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/Admin/allApplication/{Application_Name}")
	public ResponseEntity<Object> getApplicationById(@PathVariable("Application_Name") String Application_Name) {
		Inventory inventory = adminService.getApplicationByName(Application_Name);
		if (inventory != null)
			return new ResponseEntity<>(inventory, HttpStatus.OK);
		return new ResponseEntity<>("Searched Data Not Found", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/Admin/allApplication/{Application_Name}")
	public ResponseEntity<Object> updateApplication(@PathVariable String Application_Name, @RequestBody Inventory inventory) {
		String r = adminService.updateApplication(Application_Name, inventory);
		if (r.equals("updated"))
			return new ResponseEntity<>(inventory, HttpStatus.OK);
		if (r.equals("notfound"))
			return new ResponseEntity<>("Searched Data Not Found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/Admin/allApplication/{Application_Name}")
	public ResponseEntity<Object> deleteApplication(@PathVariable String Application_Name) {
		if (adminService.deleteApplication(Application_Name))
			return new ResponseEntity<>( HttpStatus.OK);
		return new ResponseEntity<>("No Application information found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Admin/users")
	public ResponseEntity<Object> getAllusers() {
		return new ResponseEntity<>(adminService.getAllusers(), HttpStatus.OK);
	}

	@GetMapping("/Admin/users/{Id}")
	public ResponseEntity<Object> getUserById(@PathVariable("Id") String Id) {
		User user = adminService.getUserById(Id);
		if (user != null)
			return new ResponseEntity<>(user, HttpStatus.OK);
		return new ResponseEntity<>("Searched Data Not Found", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/Admin/users/{Id}")
	public ResponseEntity<Object> updatePassword(@PathVariable String Id, @RequestBody User user){
		
		String r = adminService.updatePassword(Id, user);
		if (r.equals("updated"))
			return new ResponseEntity<>(user, HttpStatus.OK);
		if (r.equals("notfound"))
			return new ResponseEntity<>("Searched Data Not Found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/*
	 * @PostMapping("/adminid") public AdminLogin validateAdmin(@RequestBody
	 * AdminLogin login) { AdminLogin usr = adminService.validateAdmin(login); if
	 * (usr == null) { throw new ResourceNotFoundException("Invalid User");
	 * 
	 * } return usr; }
	 */
}
