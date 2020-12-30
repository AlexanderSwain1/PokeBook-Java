package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.LikeDao;
import com.revature.pokebook.models.Like;

@Service
public class LikeService 
{
	
	private LikeDao ld;
	
	//Construction injection
	@Autowired
	public LikeService(LikeDao ld) {
		super();
		this.ld = ld;
	}
	
	public List<Like> getLikes() throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public List<Like> getLikesByUserId(int userId) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public List<Like> getLikesByMessageId(int messageId) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public void createLike(Like like) throws Exception
	{
		throw new Exception("Not Implemented");
	}
}
