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
		if(pokemon_id <= 0 || pokemon_id > 898) {
			return null;
		}
		
		List<Message> list = md.getMessagesByPokemonID(pokemon_id);
		return list;
	}
	
	public void createMessage(Message message)
	{
		message.setAuthor(ud.getUser(message.getAuthor().getId()));
		md.createMessage(message);
	}
	
	public boolean updateMessage(Message message)
	{
		if(message.getId() <= 0) {
			return false;
		} else if(message.getPokemonId() <= 0 || message.getPokemonId() > 898) {
			return false;
		}
		md.updateMessage(message);
		return true;
	}
	
	public boolean deleteMessage(Message message)
	{
		if(message.getId() <= 0) {
			return false;
		} else if(message.getPokemonId() <= 0 || message.getPokemonId() > 898) {
			return false;
		}
		md.deleteMessage(message);
		return true;
	}
}