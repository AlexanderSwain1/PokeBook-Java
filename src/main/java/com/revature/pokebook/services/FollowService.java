package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.FollowDao;
import com.revature.pokebook.models.Follow;

@Service
public class FollowService 
{
	
	private FollowDao fd;
	
	//Construction injection
	@Autowired
	public FollowService(FollowDao fd) {
		super();
		this.fd = fd;
	}
	
	public List<Follow> getFollows()
	{
		List<Follow> list = fd.getFollows();
		
		return list;
	}
	
	public List<Follow> getByFollowerId(int followerId) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public List<Follow> getByPokemonId(int pokemonId) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public void createFollow(Follow follow) throws Exception
	{
		throw new Exception("Not Implemented");
	}
	
	public void deleteFollow(Follow follow) throws Exception
	{
		throw new Exception("Not Implemented");
	}
}
