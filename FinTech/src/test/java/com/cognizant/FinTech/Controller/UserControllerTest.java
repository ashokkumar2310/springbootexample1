package com.cognizant.FinTech.Controller;
/*
 * package com.cognizant.EasyBus.Controller;
 * 
 * 
 * 
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import org.hamcrest.Matchers; import org.junit.jupiter.api.Test; import
 * org.junit.runner.RunWith; import org.mockito.ArgumentMatchers; import
 * org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.test.web.servlet.MockMvc;
 * 
 * import com.cognizant.FinTech.Model.UserSearch; import
 * com.cognizant.FinTech.Model.User; import
 * com.cognizant.FinTech.Model.UserLogin; import
 * com.cognizant.FinTech.Service.AdminService; import
 * com.cognizant.FinTech.Service.UserService; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @WebMvcTest
 * 
 * public class UserControllerTest {
 * 
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * 
 * @MockBean private AdminService adminservice;
 * 
 * 
 * @MockBean private UserService userService;
 * 
 * 
 * 
 * 
 * @MockBean private JdbcTemplate jdbcTemplate;
 * 
 * private static ObjectMapper mapper = new ObjectMapper();
 * 
 * @Test public void testValidateUser() throws Exception {
 * 
 * UserLogin user = new UserLogin(); user.setUsername("praveen12@gmail.com");
 * user.setPassword("praveen12@123");
 * Mockito.when(userService.validateUser(ArgumentMatchers.any())).thenReturn(
 * user); String json = mapper.writeValueAsString(user);
 * mockMvc.perform(post("/userlogin").contentType(MediaType.APPLICATION_JSON).
 * characterEncoding("utf-8")
 * .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
 * .andExpect(jsonPath("$.username", Matchers.equalTo("praveen12@gmail.com")))
 * .andExpect(jsonPath("$.password", Matchers.equalTo("praveen12@123")));
 * 
 * }
 * 
 * @Test public void testUserSignUp() throws Exception {
 * 
 * User user = new User(); user.setFirstName("Praveen");
 * user.setLastName("Kumar"); user.setGender("Male");
 * user.setDateOfBirth("02-02-2000"); user.setEmailId("praveen@gmail.com");
 * user.setPassword("9443781345123456"); user.setSecurityQues("spb");
 * 
 * Mockito.when(userService.userSignUp(ArgumentMatchers.any())).thenReturn(true)
 * ; String json = mapper.writeValueAsString(user);
 * mockMvc.perform(post("/newuser").contentType(MediaType.APPLICATION_JSON).
 * characterEncoding("utf-8")
 * .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().
 * isCreated())
 * 
 * 
 * .andExpect(jsonPath("$.firstName",Matchers.equalTo("Praveen")))
 * .andExpect(jsonPath("$.lastName", Matchers.equalTo("Kumar")))
 * .andExpect(jsonPath("$.gender",Matchers.equalTo("Male")))
 * .andExpect(jsonPath("$.dateOfBirth",Matchers.equalTo("02-02-2000")))
 * .andExpect(jsonPath("$.emailId", Matchers.equalTo("praveen@gmail.com")))
 * .andExpect(jsonPath("$.password",Matchers.equalTo("9443781345123456")))
 * .andExpect(jsonPath("$.securityQues",Matchers.equalTo("spb"))); }
 * 
 * @Test public void testBooking() throws Exception {
 * 
 * UserSearch book = new UserSearch(); book.setUserId("praveen@gmail.com");
 * book.setBusno("1234"); book.setFrom("Chennai"); book.setTo("Bangalore");
 * book.setStarttime("20.00"); book.setEndtime("7.00"); book.setBustype("AC");
 * book.setFare(1000);
 * 
 * Mockito.when(userService.bookticket(ArgumentMatchers.any())).thenReturn(true)
 * ; String json = mapper.writeValueAsString(book);
 * mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON).
 * characterEncoding("utf-8")
 * .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().
 * isCreated())
 * 
 * 
 * .andExpect(jsonPath("$.userId",Matchers.equalTo("praveen@gmail.com")))
 * .andExpect(jsonPath("$.busno", Matchers.equalTo("1234")))
 * .andExpect(jsonPath("$.from",Matchers.equalTo("Chennai")))
 * .andExpect(jsonPath("$.to",Matchers.equalTo("Bangalore")))
 * .andExpect(jsonPath("$.starttime", Matchers.equalTo("20.00")))
 * .andExpect(jsonPath("$.endtime",Matchers.equalTo("7.00")))
 * .andExpect(jsonPath("$.bustype",Matchers.equalTo("AC")))
 * .andExpect(jsonPath("$.fare",Matchers.equalTo(1000))); }
 * 
 * }
 */