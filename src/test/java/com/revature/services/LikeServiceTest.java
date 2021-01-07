package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.pokebook.dao.ILikeDao;
import com.revature.pokebook.dao.IMessageDao;
import com.revature.pokebook.dao.IUserDao;
import com.revature.pokebook.models.Like;
import com.revature.pokebook.models.Message;
import com.revature.pokebook.models.User;
import com.revature.pokebook.services.LikeService;


class LikeServiceTest {

	private static LikeService ls;
	private static Like l;

	private static ILikeDao ld;
	private static IUserDao ud;
	private static IMessageDao md;
	
	@BeforeAll
	public static void setUp() {
		ls = new LikeService(ld, ud, md);
		l = new Like();
		l.setUser(new User());
		l.setMessage(new Message());
	}
	
	@Test
	void constructor() {
		ls = new LikeService();
	}
	
	@Test
	void testGetLikesByUserIdd() {
		List<Like> list = ls.getLikesByUserId(-1);
		
		assertNull(list);
	}
	
	@Test
	void testGetLikesByMessageId() {
		List<Like> list = ls.getLikesByMessageId(-1);
		
		assertNull(list);
	}
	
	@Test
	void testCreate() {
		l.getUser().setId(-1);
		boolean test = ls.create(l);
		
		assertFalse(test);
	}
	
	@Test
	void testCreate2() {
		l.getUser().setId(1);
		l.getMessage().setId(-1);
		boolean test = ls.create(l);
		
		assertFalse(test);
	}
	
	@Test
	void testDelete() {
		l.setId(-1);
		boolean test = ls.delete(l);
		
		assertFalse(test);
	}
	
	@Test
	void testDelete2() {
		l.setId(1);
		l.getMessage().setId(-1);
		boolean test = ls.delete(l);
		
		assertFalse(test);
	}
	
	@Test
	void testDelete3() {
		l.setId(1);
		l.getMessage().setId(1);
		l.getUser().setId(-1);
		boolean test = ls.delete(l);
		
		assertFalse(test);
	}
}