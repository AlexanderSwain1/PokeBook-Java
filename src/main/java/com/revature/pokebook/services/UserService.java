package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.IUserDao;
import com.revature.pokebook.dao.UserDao;
import com.revature.pokebook.models.User;

@Service
public class UserService 
{
	private IUserDao ud;
	
	@Autowired
	public UserService(IUserDao ud) 
	{
		super();
		this.ud = ud;
	}
	
	public List<User> getUsers()
	{
		return ud.getUsers();
	}
	
	public User getUser(int id)
	{
		return ud.getUser(id);
	}
	
	public User getUserByUsername(String username)
	{
		return ud.getUserByUsername(username);
	}
	
	public User getUserByEmail(String email)
	{
		return ud.getUserByEmail(email);
	}
	
	public void createUser(User user)
	{
		ud.createUser(user);
	}
	
	public void updateUser(User user)
	{
		ud.updateUser(user);
	}
	
	public User loginUser(User toLogin)
	{
		User user;
		System.out.println("Login Service");
		
		if (toLogin.getId() != 0)
		{
			System.out.println("toLogin.getId()");
			user = ud.getUser(toLogin.getId());
		}
		else if (toLogin.getUsername() != null)
		{
			System.out.println("toLogin.getUsername()");
			user= ud.getUserByUsername(toLogin.getUsername());
		}
		else if (toLogin.getEmail() != null)
		{
			System.out.println("toLogin.getEmail()");
			user= ud.getUserByEmail(toLogin.getEmail());
		}
		else
			return null;
		
		System.out.println("toLoginPsssword: " + toLogin.getPassword() + "; user: " + user.getPassword());
		if (toLogin.getPassword().equals(user.getPassword()))
			return user;
		else
			return null;
	}
	
	public void logoutUser(User user)
	{
		//Not Implemented
	}
}
