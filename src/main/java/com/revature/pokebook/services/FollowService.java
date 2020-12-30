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
	
	public List<Follow> getFollows() throws Exception
	{
		return fd.getFollows();
	}
	
	public List<Follow> getByFollowerId(int followerId) throws Exception
	{
		return fd.getByFollowerId(followerId);
	}
	
	public List<Follow> getByPokemonId(int pokemonId) throws Exception
	{
		return fd.getByPokemonId(pokemonId);
	}
	
	public void createFollow(Follow follow) throws Exception
	{
		fd.createFollow(follow);
	}
	
	public void deleteFollow(Follow follow) throws Exception
	{
		throw new Exception("Not Implemented");
	}
}
