package com.revature.pokebook.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.pokebook.models.Follow;

public interface IFollowDao 
{
	public List<Follow> getByUserId(int userId);
	
	public List<Follow> getByPokemonId(int pokemonId);
	
	public void createFollow(Follow follow);
	
	public void deleteFollow(Follow follow);
}
