package com.revature.pokebook.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.revature.pokebook.models.Like;

public interface ILikeDao 
{
	public List<Like> getLikes();
	
	public List<Like> getLikesByUserId(int userId);
	
	public List<Like> getLikesByMessageId(int messageId);
	
	public void createLike(Like like);
	
	public void deleteLike(Like like);
}
