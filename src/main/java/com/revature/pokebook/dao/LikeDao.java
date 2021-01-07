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
	
	public LikeDao() {
		super();
	}
	
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
		System.out.println(userId);
		List<Like> list = s.createQuery("FROM Like WHERE user_id = " + userId).list();
		System.out.println(list);
		return list;
	}
	
	@Override
	public List<Like> getLikesByMessageId(int messageId)
	{
		Session s = sf.getCurrentSession();
		List<Like> list = s.createQuery("FROM Like WHERE message_id = " + messageId).list();
		return list;
	}
	
	@Override
	public boolean createLike(Like like)
	{
		Session s = sf.getCurrentSession();
		s.save(like);
		return true;
	}
	
	@Override
	public boolean deleteLike(Like like)
	{
		Session s = sf.getCurrentSession();
		s.delete(like);
		return true;
	}
}
