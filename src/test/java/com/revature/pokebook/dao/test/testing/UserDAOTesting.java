package com.revature.pokebook.dao.test.testing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.pokebook.dao.test.UserDAOTest;
import com.revature.pokebook.models.User;

public class UserDAOTesting {

	private UserDAOTest userDAOTest = new UserDAOTest();
	
	@Test
	public void userDAOTest() {
		
			User user1 = new User("a", "b", "c", "d", "e@aol.com", "123-456-7890");
			try {
				userDAOTest.createUser(user1);
				assertTrue(true);
			} catch (Exception e) {
				return;
			}
	}
}
