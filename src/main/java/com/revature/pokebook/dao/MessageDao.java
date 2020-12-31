package com.revature.pokebook.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Home;
import com.revature.pokebook.models.Message;
import com.revature.utils.HibernateUtils;

@Repository
public class MessageDao 
{
	
	@Autowired
	private SessionFactory sf;
	
	
	public List<Message> getMessages() throws Exception
	{
		Session s = sf.getCurrentSession();
		CriteriaQuery<Message> cq = s.getCriteriaBuilder().createQuery(Message.class);
		cq.from(Message.class);
		return s.createQuery(cq).getResultList();
	}
	
	public Message getMessage(int id) throws Exception
	{
		Session s = sf.getCurrentSession();
		return s.get(Message.class, id);
	}
	
	public List<Message> getMessagesByPokemonID(int pokemon_id) throws Exception
	{
		Session s = sf.getCurrentSession();
		List<Message> list = s.createQuery("FROM Messages WHERE pokemon_id = " + pokemon_id).list();
		return list;
	}
	
	public void createMessage(Message message) throws Exception
	{
		Session s = sf.getCurrentSession();
		s.save(message);
	}
	
	public void updateMessage(Message message) throws Exception
	{
		Session s = sf.getCurrentSession();
		s.update(message);
	}
	
	public void deleteMessage(Message message) throws Exception
	{
		Session s = sf.getCurrentSession();
		s.delete(message);
	}
}
