package com.revature.pokebook.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pokebook.models.Follow;

@Repository
//@Transactional
public class FollowDao implements IFollowDao
{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Follow> getByUserId(int userId) 
	{
		Session s = sf.getCurrentSession();
		List<Follow> list = s.createQuery("FROM Follows WHERE user_id = " + userId).list();
		return list;
	}
	
	@Override
	public List<Follow> getByPokemonId(int pokemonId)
	{

		Session s = sf.getCurrentSession();
		List<Follow> list = s.createQuery("FROM Follows WHERE pokemon_id = " + pokemonId).list();
		return list;

	}
	
	@Override
	public void createFollow(Follow follow)
	{
		Session s = sf.getCurrentSession();

		s.save(follow);

	}
	
	@Override
	public void deleteFollow(Follow follow)
	{
		Session s = sf.getCurrentSession();
		s.delete(follow);
	}
}
