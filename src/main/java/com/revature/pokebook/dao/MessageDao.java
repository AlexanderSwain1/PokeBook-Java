package com.revature.pokebook.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pokebook.models.Message;

@Repository
@Transactional
public class MessageDao implements IMessageDao
{
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Message> getMessages()
	{
		Session s = sf.getCurrentSession();
		CriteriaQuery<Message> cq = s.getCriteriaBuilder().createQuery(Message.class);
		cq.from(Message.class);
		return s.createQuery(cq).getResultList();
	}
	
	@Override
	public Message getMessage(int id)
	{
		Session s = sf.getCurrentSession();
		return s.load(Message.class, id);
	}
	
	@Override
	public List<Message> getMessagesByPokemonID(int pokemon_id)
	{
		Session s = sf.getCurrentSession();
		List<Message> list = s.createQuery("FROM Messages WHERE pokemon_id = " + pokemon_id).list();
		return list;
	}
	
	@Override
	public void createMessage(Message message)
	{
		Session s = sf.getCurrentSession();
		s.save(message);
	}
	
	@Override
	public void updateMessage(Message message)
	{
		Session s = sf.getCurrentSession();
		s.update(message);
	}
	
	@Override
	public void deleteMessage(Message message)
	{
		Session s = sf.getCurrentSession();
		s.delete(message);
	}
}
