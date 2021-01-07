package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.pokebook.models.User;
import com.revature.pokebook.services.UserService;


class UserServiceTest {

	private static UserService us;
	private static User u;

	
	@BeforeAll
	public static void setUp() {
		us = new UserService();
		u = new User();
	}
	
}

/*
 * assertTrue single params
 * assertFalse
 * 
 * assertEquals (1, id) 1st any var, compared to 2nd
 * 
 * assertNotEquals(0, list.size)
 * 
 * assertNull(if null) 1param
 * 
 */