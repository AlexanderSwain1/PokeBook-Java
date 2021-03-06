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
	private IFollowDao fd;
	private IUserDao ud;
	
	@Autowired
	public FollowService(IFollowDao fd, IUserDao ud) {
		super();
		this.fd = fd;
		this.ud = ud;
	}
	
	public FollowService() {
		super();
	}
	
	public Follow getFollow(Follow follow) {
		if(follow.getUser().getId() <= 0) {
			return null;
		} else if(follow.getPokemonId() <= 0) {
			return null;
		} else if(follow.getPokemonId() > 898) {
			return null;
		}
		return fd.getFollow(follow);
	}

	public List<Follow> getByUserId(int followerId)
	{
		if(followerId <= 0) {
			return null;
		}
		return fd.getByUserId(followerId);
	}
	
	public List<Follow> getByPokemonId(int pokemonId)
	{
		if(pokemonId <= 0) {
			return null;
		} else if(pokemonId > 898) {
			return null;
		}
		return fd.getByPokemonId(pokemonId);
	}
	
	public Follow createFollow(Follow follow)
	{
		if(follow.getPokemonId() <= 0) {
			return null;
		} else if(follow.getPokemonId() > 898) {
			return null;
		} else if(follow.getUser().getId() <= 0) {
			return null;
		}
		follow.setUser(ud.getUser(follow.getUser().getId()));
		Follow f = fd.createFollow(follow);
		return f;
	}
	
	public boolean deleteFollow(Follow follow)
	{
		System.out.println("DELETE SERVE: " + follow);
		if(follow.getId() <= 0) {
			return false;
		}
		return fd.deleteFollow(follow);
	}
	
}
