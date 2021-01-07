package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.revature.pokebook.models.Message;

public interface IMessageDao 
{
	public List<Message> getMessages();
	
	public Message getMessage(int id);
	
	public List<Message> getMessagesByPokemonID(int pokemon_id);
	
	public boolean createMessage(Message message);
	
	public boolean updateMessage(Message message);
	
	public boolean deleteMessage(Message message);
}
