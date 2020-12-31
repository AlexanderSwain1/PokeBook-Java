package com.revature.pokebook.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pokebook.models.Follow;

@Repository
public class FollowDao 
{
	@Autowired
	private SessionFactory sf;
	
	
	public List<Follow> getByUserId(int userId) 
	{
		Session s = sf.getCurrentSession();
		List<Follow> list = s.createQuery("FROM Follows WHERE user_id = " + userId).list();
		return list;
	}
	
	public List<Follow> getByPokemonId(int pokemonId)
	{

		Session s = sf.getCurrentSession();
		List<Follow> list = s.createQuery("FROM Follows WHERE pokemon_id = " + pokemonId).list();
		return list;

	}
	
	public void createFollow(Follow follow)
	{
		Session s = sf.getCurrentSession();

		s.save(follow);

	}
	
	public void deleteFollow(Follow follow)
	{
		Session s = sf.getCurrentSession();
		s.delete(follow);
	}
}
