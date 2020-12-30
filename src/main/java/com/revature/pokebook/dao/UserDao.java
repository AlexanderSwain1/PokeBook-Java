package com.revature.pokebook.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.pokebook.models.User;
import com.revature.pokebook.utilities.HibernateUtility;

@Repository
public class UserDao 
{
	public List<User> getUsers() throws Exception
	{
		Session ses = HibernateUtility.getSession();

		List<User> list = ses.createQuery("FROM User").list();
		
		return list;
	}
	
	public List<User> getUser(int id) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public User getUserByUsername(String username) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public User getUserByEmail(String email) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public void createUser(User user) throws Exception {
	Session ses = HibernateUtility.getSession();
	try {
		ses.save(user);
		return;
	} catch (Exception e) {
		return;
	}
}
	public List<User> updateUser(User user) throws Exception
	{
		throw new Exception("Not Implemented");
	}
}
