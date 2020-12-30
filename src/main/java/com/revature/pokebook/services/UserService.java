package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.UserDao;
import com.revature.pokebook.models.User;

@Service
public class UserService 
{
	
	private UserDao ud;
	
	//Construction injection
	@Autowired
	public UserService(UserDao ud) {
		super();
		this.ud = ud;
	}
	
	public List<User> getUsers() throws Exception
	{
		throw new Exception("Not Implemented");
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
	
	public void createUser(User user) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public List<User> updateUser(User user) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public User loginUser(String username, String password) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public void logoutUser(User user) throws Exception
	{
		throw new Exception("Not Implemented");
	}
}
