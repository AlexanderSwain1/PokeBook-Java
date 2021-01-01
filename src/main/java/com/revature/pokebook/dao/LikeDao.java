package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.pokebook.models.Like;

@Repository
@Transactional
public class LikeDao implements ILikeDao
{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Like> getLikes()
	{
		Session s = sf.getCurrentSession();
		CriteriaQuery<Like> cq = s.getCriteriaBuilder().createQuery(Like.class);
		cq.from(Like.class);
		return s.createQuery(cq).getResultList();
	}
	
	@Override
	public List<Like> getLikesByUserId(int userId)
	{
		Session s = sf.getCurrentSession();
		List<Like> list = s.createQuery("FROM Likes WHERE user_id = " + userId).list();
		return list;
	}
	
	@Override
	public List<Like> getLikesByMessageId(int messageId)
	{
		Session s = sf.getCurrentSession();
		List<Like> list = s.createQuery("FROM Likes WHERE message_id = " + messageId).list();
		return list;
	}
	
	@Override
	public void createLike(Like like)
	{
		Session s = sf.getCurrentSession();
		s.save(like);
	}
	
	@Override
	public void deleteLike(Like like)
	{
		Session s = sf.getCurrentSession();
		s.delete(like);
	}
}
