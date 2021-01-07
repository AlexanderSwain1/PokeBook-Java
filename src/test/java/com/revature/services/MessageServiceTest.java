package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.pokebook.dao.IMessageDao;
import com.revature.pokebook.dao.IUserDao;
import com.revature.pokebook.models.Message;
import com.revature.pokebook.models.User;
import com.revature.pokebook.services.MessageService;


class MessageServiceTest {

	private static MessageService ms;
	private static Message m;
	
	private static IMessageDao md;
	private static IUserDao ud;

	
	@BeforeAll
	public static void setUp() {
		ms = new MessageService(md, ud);
		m = new Message();
		m.setAuthor(new User());
	}
	
	@Test
	void testConstructor() {
		ms = new MessageService();
	}
	
	@Test
	void testGetMessage() {
		Message test = ms.getMessage(-1);
		
		assertNull(test);
	}
	
	@Test
	void testGetMessagesByPokemonId() {
		List<Message> test = ms.getMessagesByPokemonID(-1);
		
		assertNull(test);
	}
	
	@Test
	void testGetMessagesByPokemonId2() {
		List<Message> test = ms.getMessagesByPokemonID(900);
		
		assertNull(test);
	}
	
	@Test
	void testCreateMessage() {
		m.getAuthor().setId(-1);
		boolean test = ms.createMessage(m);
		
		assertFalse(test);
	}
	
	@Test
	void testCreateMessage2() {
		m.getAuthor().setId(1);
		m.setContent("");
		boolean test = ms.createMessage(m);
		
		assertFalse(test);
	}
	
	@Test
	void testCreateMessage3() {
		m.getAuthor().setId(1);
		m.setContent("Hello");
		m.setPokemonId(-1);
		boolean test = ms.createMessage(m);
		
		assertFalse(test);
	}
	
	@Test
	void testCreateMessage4() {
		m.getAuthor().setId(1);
		m.setContent("Hello");
		m.setPokemonId(900);
		boolean test = ms.createMessage(m);
		
		assertFalse(test);
	}

	@Test
	void testUpdateMessage2() {
		m.setContent("");
		boolean test = ms.updateMessage(m);
		
		assertFalse(test);
	}
	
	@Test
	void testUpdateMessage3() {
		m.setContent("hello");
		m.setPokemonId(-1);
		boolean test = ms.updateMessage(m);
		
		assertFalse(test);
	}
	
	@Test
	void testUpdateMessage4() {
		m.setContent("hello");
		m.setPokemonId(900);
		boolean test = ms.updateMessage(m);
		
		assertFalse(test);
	}
	
	@Test
	void testDeleteMessage() {
		m.setId(-1);
		boolean test = ms.deleteMessage(m);
		
		assertFalse(test);
	}
	
	@Test
	void testDeleteMessage2() {
		m.setId(1);
		m.setPokemonId(-1);
		boolean test = ms.deleteMessage(m);
		
		assertFalse(test);
	}
	
	@Test
	void testDeleteMessage3() {
		m.setId(1);
		m.setPokemonId(900);
		boolean test = ms.deleteMessage(m);
		
		assertFalse(test);
	}
	
}