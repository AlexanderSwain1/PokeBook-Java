package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pokebook.models.User;

@Repository
@Transactional
public class UserDao implements IUserDao
{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<User> getUsers()
	{
		Session s = sf.getCurrentSession();
		CriteriaQuery<User> cq = s.getCriteriaBuilder().createQuery(User.class);
		cq.from(User.class);
		return s.createQuery(cq).getResultList();
	}
	
	@Override
	public User getUser(int id)
	{
		Session s = sf.getCurrentSession();
		return s.load(User.class, id);
	}
	
	@Override
	public User getUserByUsername(String username)
	{
		Session s = sf.getCurrentSession();
		return s.load(User.class, username);
	}
	
	@Override
	public User getUserByEmail(String email)
	{
		Session s = sf.getCurrentSession();
		return s.load(User.class, email);
	}
	
	@Override
	public void createUser(User user)
	{
		Session s = sf.getCurrentSession();
		s.save(user);
	}
	
	@Override
	public void updateUser(User user)
	{
		Session s = sf.getCurrentSession();
		s.update(user);
	}
}
