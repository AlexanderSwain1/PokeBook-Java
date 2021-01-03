package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.FollowDao;
import com.revature.pokebook.dao.IFollowDao;
import com.revature.pokebook.dao.IUserDao;
import com.revature.pokebook.dao.UserDao;
import com.revature.pokebook.models.Follow;

@Service
public class FollowService 
{	
	private IUserDao ud;
	private IFollowDao fd;
	
	@Autowired
	public FollowService(IFollowDao fd, IUserDao ud) {
		super();
		this.fd = fd;
		this.ud = ud;
	}
	

	public List<Follow> getByUserId(int followerId)
	{
		return fd.getByUserId(followerId);
		
	}
	
	public List<Follow> getByPokemonId(int pokemonId)
	{
		return fd.getByPokemonId(pokemonId);
	}
	
	public void createFollow(Follow follow)
	{
		follow.setUser(ud.getUser(follow.getUser().getId()));
		fd.createFollow(follow);
	}
	
	public void deleteFollow(int id)
	{
		Follow f = new Follow();
		f.setId(id);
		fd.deleteFollow(f);
	}
	
}
