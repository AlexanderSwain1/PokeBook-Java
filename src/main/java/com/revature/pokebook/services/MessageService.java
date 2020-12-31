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

	@Autowired
	public MessageService(MessageDao md) {
		super();
		this.md = md;
	}
	
	public List<Message> getMessages()
	{
		return md.getMessages();
	}
	
	public Message getMessage(int id)
	{
		return md.getMessage(id);
	}
	
	public List<Message> getMessagesByPokemonID(int pokemon_id)
	{
		return md.getMessagesByPokemonID(pokemon_id);
	}
	
	public void createMessage(Message message)
	{
		md.createMessage(message);
	}
	
	public void updateMessage(Message message)
	{
		md.updateMessage(message);
	}
	
	public void deleteMessage(Message message)
	{
		md.deleteMessage(message);
	}
}