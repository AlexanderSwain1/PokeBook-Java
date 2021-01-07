package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.pokebook.models.Follow;
import com.revature.pokebook.services.FollowService;

class FollowServiceTest {

	private static FollowService fs;
	private static Follow f;

	@BeforeAll
	public static void setUp() {
		fs = new FollowService();
		f = new Follow();
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