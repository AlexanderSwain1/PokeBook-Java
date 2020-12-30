package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.MessageDao;
import com.revature.pokebook.models.Message;

@Service
public class MessageService 
{
	
	private MessageDao md;
	
	//Construction injection
	@Autowired
	public MessageService(MessageDao md) {
		super();
		this.md = md;
	}
	
	public List<Message> getMessages() throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public Message getMessage(int id) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public List<Message> getMessagesByPokemonID(int pokemon_id) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public void createMessage(Message message) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public void updateMessage(Message message) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public void deleteMessage(Message message) throws Exception
	{
		throw new Exception("Not Implemented");
	}
}