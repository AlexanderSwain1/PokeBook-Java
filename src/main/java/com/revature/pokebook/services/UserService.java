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
		return ud.getUsers();
	}
	
	public List<User> getUser(int id) throws Exception
	{
		return ud.getUser(id);
	}
	
	public User getUserByUsername(String username) throws Exception
	{
		return ud.getUserByUsername(username);
	}
	
	public User getUserByEmail(String email) throws Exception
	{
		return ud.getUserByEmail(email);
	}
	
	public void createUser(User user) throws Exception
	{
		ud.createUser(user);
	}
	
	public List<User> updateUser(User user) throws Exception
	{
		return ud.updateUser(user);
	}
	
	public boolean loginUser(String username, String password) throws Exception
	{
		//Not Implemented
		return false;
	}
	
	public void logoutUser(User user) throws Exception
	{
		//Not Implemented
	}
}
