package com.example.springbackend;

import com.example.springbackend.model.User;
import com.example.springbackend.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserService  userService;

	//Had no success using the embedded Mongodb dependency, therefore it will change the db.

//	@Before
//	public void saveUser() {
//		userService.saveUser(new User("Jaime", "681 st", 45));
//	}

	@Test
	public void getUser() {
		User user = userService.getById("63e99db2bc467b261ff58d58");
		Assert.assertEquals("Jaime", user.getName());
	}

	@Test
	public void editUser() {
		User user = userService.getById("63e99db2bc467b261ff58d58");
		user.setName("Filemon");
		userService.saveUser(user);
		Assert.assertEquals("Filemon", user.getName());
	}

	@Test
	public void deleteUser() {
		userService.deleteUser("63e99db2bc467b261ff58d58");
	}

}
