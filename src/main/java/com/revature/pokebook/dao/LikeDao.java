package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.pokebook.models.Like;
import com.revature.pokebook.models.Message;

@Repository
public class LikeDao 
{
	@Autowired
	private SessionFactory sf;
	
	public List<Like> getLikes() throws Exception
	{
		Session s = sf.getCurrentSession();
		CriteriaQuery<Like> cq = s.getCriteriaBuilder().createQuery(Like.class);
		cq.from(Like.class);
		return s.createQuery(cq).getResultList();
	}
	
	public List<Like> getLikesByUserId(int userId) throws Exception
	{
		Session s = sf.getCurrentSession();
		List<Like> list = s.createQuery("FROM Likes WHERE user_id = " + userId).list();
		return list;
	}
	
	public List<Like> getLikesByMessageId(int messageId) throws Exception
	{
		Session s = sf.getCurrentSession();
		List<Like> list = s.createQuery("FROM Likes WHERE message_id = " + messageId).list();
		return list;
	}
	
	public void createLike(Like like) throws Exception
	{
		Session s = sf.getCurrentSession();
		s.save(like);
	}
	
	public void deleteLike(Message message) throws Exception
	{
		Session s = sf.getCurrentSession();
		s.delete(like);
	}
}
