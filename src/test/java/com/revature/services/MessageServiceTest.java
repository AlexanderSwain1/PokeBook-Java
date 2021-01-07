package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.pokebook.models.Message;
import com.revature.pokebook.services.MessageService;


class MessageServiceTest {

	private static MessageService ms;
	private static Message m;

	
	@BeforeAll
	public static void setUp() {
		ms = new MessageService();
		m = new Message();
	}
	
}

/*
 * assertTrue single params
 * assertFalse
 * 
 * assertEquals (1, id) 1st any var, compared to 2nd
 * 
 * assertNotEquals(0, list.size)
 * 
 * assertNull(if null) 1param
 * 
 */