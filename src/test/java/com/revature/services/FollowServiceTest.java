package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.pokebook.dao.IFollowDao;
import com.revature.pokebook.dao.IUserDao;
import com.revature.pokebook.models.Follow;
import com.revature.pokebook.models.User;
import com.revature.pokebook.services.FollowService;

class FollowServiceTest {

	private static FollowService fs;
	private static Follow f;

	private static IFollowDao fd;
	private static IUserDao ud;

	@BeforeAll
	public static void setUp() {
		fs = new FollowService(fd, ud);
		f = new Follow();
		f.setUser(new User());
	}
	
	@Test
	void testConstructor() {
		fs= new FollowService();
	}
	
	@Test
	void testGetFollow() {
		f.getUser().setId(-1);
		Follow test = fs.getFollow(f);
		
		assertNull(test);
	}
	
	@Test
	void testGetFollow2() {
		f.getUser().setId(1);
		f.setPokemonId(-1);
		Follow test = fs.getFollow(f);
		
		assertNull(test);
	}
	
	@Test
	void testGetFollow3() {
		f.getUser().setId(1);
		f.setPokemonId(900);
		Follow test = fs.getFollow(f);
		
		assertNull(test);
	}
	
	@Test
	void testGetByUserId() {
		List<Follow> test = fs.getByUserId(-1);
		
		assertNull(test);
	}
	
	@Test
	void testGetByPokemonId() {
		List<Follow> test = fs.getByPokemonId(-1);
		
		assertNull(test);
	}
	
	@Test
	void testGetByPokemonId2() {
		List<Follow> test = fs.getByPokemonId(900);
		
		assertNull(test);
	}
	
	@Test
	void testCreateFollow() {
		f.setPokemonId(-1);
		Follow test = fs.createFollow(f);
		
		assertNull(test);
	}
	
	@Test
	void testCreateFollow2() {
		f.setPokemonId(900);
		Follow test = fs.createFollow(f);
		
		assertNull(test);
	}
	
	@Test
	void testCreateFollow3() {
		f.setPokemonId(1);
		f.getUser().setId(-1);
		Follow test = fs.createFollow(f);
		
		assertNull(test);
	}
	
	@Test
	void testDeleteFollow() {
		f.setId(-1);
		boolean test = fs.deleteFollow(f);
		
		assertFalse(test);
	}
	
	@Test
	void testDeleteFollow2() {
		f.setId(1);
		f.setPokemonId(-1);
		boolean test = fs.deleteFollow(f);
		
		assertFalse(test);
	}
	
	@Test
	void testDeleteFollow3() {
		f.setId(1);
		f.setPokemonId(900);
		boolean test = fs.deleteFollow(f);
		
		assertFalse(test);
	}
	
	@Test
	void testDeleteFollow4() {
		f.setId(1);
		f.setPokemonId(1);
		f.getUser().setId(-1);
		boolean test = fs.deleteFollow(f);
		
		assertFalse(test);
	}
}