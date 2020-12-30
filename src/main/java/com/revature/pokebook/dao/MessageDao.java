package com.revature.pokebook.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.pokebook.models.Message;

@Repository
public class MessageDao 
{
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
