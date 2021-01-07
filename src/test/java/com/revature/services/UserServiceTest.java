package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.pokebook.dao.IUserDao;
import com.revature.pokebook.models.User;
import com.revature.pokebook.services.UserService;


class UserServiceTest {

	private static UserService us;
	private static User u;

	private static IUserDao ud;
	
	@BeforeAll
	public static void setUp() {
		us = new UserService(ud);
		u = new User();
	}
	
	@Test
	void testConstructor() {
		us = new UserService();
	}
	
	@Test
	void testGetUser(){
		User test = us.getUser(-1);
		
		assertNull(test);
	}
	
	@Test
	void testGetUserByUsername(){
		User test = us.getUserByUsername("");
		
		assertNull(test);
	}
	
	@Test
	void testGetUserByEmail(){
		User test = us.getUserByEmail("");
		
		assertNull(test);
	}
	
	@Test
	void testCreateUser(){
		u.setUsername("");
		boolean test = us.createUser(u);
		
		assertFalse(test);
	}
	
	@Test
	void testCreateUser2(){
		u.setUsername("Username");
		u.setPassword("");
		boolean test = us.createUser(u);
		
		assertFalse(test);
	}
	
	@Test
	void testUpdateUser() {
		u.setId(0);
		boolean test = us.updateUser(u);
		
		assertFalse(test);
	}
	
	@Test
	void testLoginUser() {
		u.setId(0);
		User test = us.loginUser(u);
		
		assertNull(test);
	}
	
	@Test
	void testLoginUser2() {
		u.setId(2);
		u.setUsername(null);
		User test = us.loginUser(u);
		
		assertNull(test);
	}
	
	@Test
	void testLoginUser3() {
		u.setId(3);
		u.setUsername("Username");
		u.setEmail(null);
		User test = us.loginUser(u);
		
		assertNull(test);
	}

	@Test
	void testLoginUser4() {
		u.setId(4);
		u.setUsername("Username");
		u.setEmail("email@email.com");
		User test = us.loginUser(u);
		
		assertNull(test); //Unable to find user as there are no dependencies
	}
	
	@Test
	void testLogoutUser() {
		
	}
}
