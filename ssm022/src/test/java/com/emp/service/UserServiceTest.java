package com.emp.service;


import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserServiceTest {
	//注入业务层对象
	@Resource
	private UserService userService;
	
	@Test
	public void testUserName() {
		User user = userService.getByUserName("ls");
		System.out.println(user);
	}
	
	@Test
	public void testRoles() {
		Set<String> roles = userService.getRoles("ls");
		System.out.println(roles);
	}
	
	@Test
	public void testPermissions() {
		Set<String> pers = userService.getPermissions("ls");
		System.out.println(pers);
	}
	
	
	
	
}
