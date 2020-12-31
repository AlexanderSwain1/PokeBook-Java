package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pokebook.models.User;

@Repository
public class UserDao 
{
	@Autowired
	private SessionFactory sf;
	
	public List<User> getUsers()
	{
		Session s = sf.getCurrentSession();
		CriteriaQuery<User> cq = s.getCriteriaBuilder().createQuery(User.class);
		cq.from(User.class);
		return s.createQuery(cq).getResultList();
	}
	
	public User getUser(int id)
	{
		Session s = sf.getCurrentSession();
		return s.get(User.class, id);
	}
	
	public User getUserByUsername(String username)
	{
		Session s = sf.getCurrentSession();
		return s.get(User.class, username);
	}
	
	public User getUserByEmail(String email)
	{
		Session s = sf.getCurrentSession();
		return s.get(User.class, email);
	}
	
	
	public void createUser(User user)
	{
		Session s = sf.getCurrentSession();
		s.save(user);
	}
	
	public void updateUser(User user)
	{
		Session s = sf.getCurrentSession();
		s.update(user);
	}
	
}
