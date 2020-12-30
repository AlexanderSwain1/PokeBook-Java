package com.revature.pokebook.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.pokebook.models.Like;

@Repository
public class LikeDao 
{
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
