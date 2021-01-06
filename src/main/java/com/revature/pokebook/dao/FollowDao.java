package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pokebook.models.Follow;

@Repository
@Transactional
public class FollowDao implements IFollowDao
{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Follow getFollow(Follow follow){

		Session s = sf.getCurrentSession();
		List<Follow> list = s.createQuery("From Follow WHERE pokemon_id = " + follow.getPokemonId() + " and user_id = " + follow.getUser().getId()).list();
		if (list.size() == 1)
			return list.get(0);
		return null;
	}
	
	@Override
	public List<Follow> getByUserId(int userId) 
	{
		Session s = sf.getCurrentSession();
		List<Follow> list = s.createQuery("FROM Follow WHERE user_id = " + userId).list();
		return list;
	}
	
	@Override
	public List<Follow> getByPokemonId(int pokemonId)
	{
		Session s = sf.getCurrentSession();
		List<Follow> list = s.createQuery("FROM Follow WHERE pokemon_id = " + pokemonId).list();
		return list;
	}
	
	@Override
	public Follow createFollow(Follow follow)
	{
		Session s = sf.getCurrentSession();
		s.save(follow);
		
		Follow f = new Follow();
		
		List<Follow> list = s.createQuery("From Follow WHERE pokemon_id = " + follow.getPokemonId() + " and user_id = " + follow.getUser().getId()).list();
		if (list.size() == 1) {
			f = list.get(0);
		}
		return f;
	}
	
	@Override
	public void deleteFollow(Follow follow)
	{

		Session s = sf.getCurrentSession();

		s.delete(follow);
	}
}