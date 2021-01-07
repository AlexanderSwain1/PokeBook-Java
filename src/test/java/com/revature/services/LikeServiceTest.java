package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.pokebook.models.Like;
import com.revature.pokebook.services.LikeService;


class LikeServiceTest {

	private static LikeService ls;
	private static Like l;

	
	@BeforeAll
	public static void setUp() {
		ls = new LikeService();
		l = new Like();
	}
	
	@Test
	void testInvalidUserId() {
		List<Like> list = ls.getLikesByUserId(-1);
		
		assertNull(list);
	}
	
	@Test
	void testInvalidMessageId() {
		List<Like> list = ls.getLikesByMessageId(-1);
		
		assertNull(list);
	}
	
	@Test
	void testInvalidDeleteId() {
		l.setId(-1);
		boolean test = ls.delete(l);
		
		assertFalse(test);
	}
	
	@Test
	void testInvalidDeleteMessageId() {
		l.getMessage().setId(-1);
		boolean test = ls.delete(l);
		
		assertFalse(test);
	}
	
	@Test
	void testInvalidDeleteUserId() {
		l.getUser().setId(-1);
		boolean test = ls.delete(l);
		
		assertFalse(test);
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