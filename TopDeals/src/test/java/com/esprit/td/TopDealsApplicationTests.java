package com.esprit.td;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.td.entities.User;
import com.esprit.td.enums.Role;
import com.esprit.td.responses.MessageResponse;
import com.esprit.td.services.StockService;
import com.esprit.td.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopDealsApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private StockService stockService;
	
	@Test
	public void contextLoads() throws ParseException{
		
		stockService.retrieveAll();
		
			/*User user = new User();
			user.setFirstName("Wael");
			user.setLastName("Hamdi");
			user.setEmail("wael1.hamdi1@esprit.tn");
			user.setUsername("waelhamdi");
			user.setPassword("password");
	        user.setRole(Role.ROLE_ADMIN);
	        user.setAdress("Tunis");
	        MessageResponse result = userService.save(user);
	        System.out.println(result);*/


		}
		
	

}
