package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.IMessageDao;
import com.revature.pokebook.dao.IUserDao;
import com.revature.pokebook.dao.MessageDao;
import com.revature.pokebook.models.Message;

@Service
public class MessageService 
{
	private IUserDao ud;
	private IMessageDao md;

	@Autowired
	public MessageService(IMessageDao md, IUserDao ud) {
		super();
		this.md = md;
		this.ud = ud;
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
		message.setAuthor(ud.getUser(message.getAuthor().getId()));
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