package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pokebook.models.Follow;

@Repository
@Transactional
public class FollowDao {
	
	@Autowired
	private SessionFactory sf;
	
	public List<Follow> getFollows()
	{
		Session s = sf.getCurrentSession();
		CriteriaQuery<Follow> cq = s.getCriteriaBuilder().createQuery(Follow.class);
		cq.from(Follow.class);
		return s.createQuery(cq).getResultList();
	}
	
	public List<Follow> getFollowerById(int followerId)
	{
		
	}
	
	public List<Follow> getByPokemonId(int pokemonId)
	{
		
	}
	
	public void createFollow(Follow follow)
	{
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(follow);
	}
	
	public void deleteFollow(Follow follow)
	{
		Session s = sf.getCurrentSession();
		s.delete(follow);
	}
}
