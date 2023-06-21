package com.cognizant.FinTech.Controller;




import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.FinTech.Model.AdminLogin;
import com.cognizant.FinTech.Model.Inventory;
import com.cognizant.FinTech.Service.AdminService;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest


public class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private AdminService adminService;

	/*
	 * @MockBean private UserService userService;
	 * 
	 */
	
	
	
	@MockBean
	private JdbcTemplate jdbcTemplate;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	/*
	 * @Test public void testValidateAdmin() throws Exception {
	 * 
	 * AdminLogin admin = new AdminLogin();
	 * admin.setUsername("praveen12@gmail.com"); admin.setPassword("praveen12@123");
	 * Mockito.when(adminService.validateAdmin(ArgumentMatchers.any())).thenReturn(
	 * admin); String json = mapper.writeValueAsString(admin);
	 * mockMvc.perform(post("/adminid").contentType(MediaType.APPLICATION_JSON).
	 * characterEncoding("utf-8")
	 * .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	 * .andExpect(jsonPath("$.username", Matchers.equalTo("praveen12@gmail.com")))
	 * .andExpect(jsonPath("$.password", Matchers.equalTo("praveen12@123")));
	 * 
	 * }
	 */
	@Test
	public void testAddApplication() throws Exception {
		
		Inventory inv = new Inventory();
		inv.setApplication_Name("EXL");
		inv.setPoint_Of_Contact("Sharad");
		inv.setBusiness_Usage("Language translation");
		inv.setIt_Owner("DeBarros, Melanie");
		inv.setSME("Sharad Gupta");
		inv.setBusiness_Owner("Butler, Steven");
		inv.setProduction_Server("VMPIP-EEXLAP07 , VMPIP-EEXLAP08");
		inv.setTest_Server("VMPIT-EEXLAP01 , VMPIT-EEXLAP02");
		inv.setDev_Server("NA");
		inv.setDB_Production_Server("VMPIP-E4SWM002");
		inv.setDB_Test_Server("VMPIT-E4SWM001");
		inv.setDB_Dev_Server("out of scope");
		Mockito.when(adminService.AddApplication(ArgumentMatchers.any())).thenReturn(true);
		String json = mapper.writeValueAsString(inv);
		mockMvc.perform(post("/Admin/addbus").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
		
		
		  .andExpect(jsonPath("$.Application_Name",Matchers.equalTo("EXL")))
		  .andExpect(jsonPath("$.Point_Of_Contact", Matchers.equalTo("Sharad")))
		  .andExpect(jsonPath("$.Business_Usage",Matchers.equalTo("Language translation")))
		  .andExpect(jsonPath("$.It_Owner",Matchers.equalTo("Butler, Steven")))
		  .andExpect(jsonPath("$.Production_Server",Matchers.equalTo("VMPIP-EEXLAP07 , VMPIP-EEXLAP08")))
		  .andExpect(jsonPath("$.Test_Server", Matchers.equalTo("VMPIT-EEXLAP01 , VMPIT-EEXLAP02")))
		  .andExpect(jsonPath("$.Dev_Server",Matchers.equalTo("NA")))
		  .andExpect(jsonPath("$.DB_Production_Server",Matchers.equalTo("VMPIP-E4SWM002")))
		  .andExpect(jsonPath("$.DB_Test_Server",Matchers.equalTo("VMPIT-E4SWM001")))
		  .andExpect(jsonPath("$.DB_Dev_Server",Matchers.equalTo("out of scope")));
	}
	
	
//	@Test
//	public void testUpdateBus() throws Exception {
//
//		Bus bus = new Bus();
//		bus.setBusno("1234");
//		bus.setFrom("Chennai");
//		bus.setTo("Coimbatore");
//		bus.setStarttime("7.00");
//		bus.setEndtime(("9.00"));
//		bus.setBustype("AC");
//		bus.setFare(1000);
//		bus.setTotalseat(50);
//		
//		Mockito.when(adminService.updatebus(ArgumentMatchers.any(),ArgumentMatchers.any())).thenReturn(true);
//		String json = mapper.writeValueAsString(bus);
//		mockMvc.perform(put("/Admin/allbus/{id}","1").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
//				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
////				.andExpect(jsonPath("$.busName", Matchers.equalTo("Two States")))
////				.andExpect(jsonPath("$.firstName", Matchers.equalTo("Minu")));
//	}

//@Test
//public void testGetAllUsers() throws Exception {
//	List<User> users = new ArrayList<>();
//	User user = new User();
//	user.setFirstName("Praveen");
//	user.setLastName("Kumar");
//	user.setGender("Male");
//	user.setDateOfBirth("02-02-2000");
//	user.setContactNumber(812);
//	user.setEmailId("praveen@gmail.com");
//	user.setPassword("9443781345123456");
//	user.setSecurityQues("spb");
//	((List<User>) user).addAll(users);
//	Mockito.when(adminService.getAllusers()).thenReturn(users);
//	mockMvc.perform(get("/Admin/users")).andExpect(status().isOk())
//	.andExpect(jsonPath("$.firstName",Matchers.equalTo("Praveen")))
//	  .andExpect(jsonPath("$.lastName", Matchers.equalTo("Kumar")))
//	  .andExpect(jsonPath("$.gender",Matchers.equalTo("Male")))
//	  .andExpect(jsonPath("$.dateOfBirth",Matchers.equalTo("02-02-2000")))
//	  .andExpect(jsonPath("$.contactNumber",Matchers.equalTo(812)))
//	  .andExpect(jsonPath("$.emailId", Matchers.equalTo("praveen@gmail.com")))
//	  .andExpect(jsonPath("$.password",Matchers.equalTo("9443781345123456")))
//	  .andExpect(jsonPath("$.securityQues",Matchers.equalTo("spb")));
//}

}

