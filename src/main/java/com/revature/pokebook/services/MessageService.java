package com.revature.pokebook.services;

import java.sql.Date;
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
	
	public MessageService() {
		super();
	}
	
	public List<Message> getMessages()
	{
		return md.getMessages();
	}
	
	public Message getMessage(int id)
	{
		if(id <= 0) {
			return null;
		}
		return md.getMessage(id);
	}
	
	public List<Message> getMessagesByPokemonID(int pokemon_id)
	{
		if(pokemon_id <= 0) {
			return null;
		} else if(pokemon_id > 898) {
			return null;
		}
		
		return md.getMessagesByPokemonID(pokemon_id);
	}
	
	public boolean createMessage(Message message)
	{
		if(message.getAuthor().getId() <= 0) {
			return false;
		} else if(message.getContent() == "") {
			return false;
		} else if(message.getPokemonId() <= 0) {
			return false;
		} else if(message.getPokemonId() > 898) {
			return false;
		}
		message.setAuthor(ud.getUser(message.getAuthor().getId()));
		return md.createMessage(message);
	}
	
	public boolean updateMessage(Message message)
	{
		if(message.getContent() == "") {
			return false;
		} else if(message.getPokemonId() <= 0) {
			return false;
		} else if(message.getPokemonId() > 898) {
			return false;
		}
		return md.updateMessage(message);
	}
	
	public boolean deleteMessage(Message message)
	{
		if(message.getId() <= 0) {
			return false;
		} else if(message.getPokemonId() <= 0) {
			return false;
		} else if(message.getPokemonId() > 898) {
			return false;
		}
		return md.deleteMessage(message);
	}
}