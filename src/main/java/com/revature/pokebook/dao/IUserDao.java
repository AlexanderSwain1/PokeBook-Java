package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.revature.pokebook.models.User;

public interface IUserDao 
{
	public List<User> getUsers();
	
	public User getUser(int id);
	
	public User getUserByUsername(String username);
	
	public User getUserByEmail(String email);
	
	public boolean createUser(User user);
	
	public boolean updateUser(User user);
}
