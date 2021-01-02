package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.ILikeDao;
import com.revature.pokebook.dao.IMessageDao;
import com.revature.pokebook.dao.IUserDao;
import com.revature.pokebook.dao.LikeDao;
import com.revature.pokebook.dao.MessageDao;
import com.revature.pokebook.dao.UserDao;
import com.revature.pokebook.models.Like;

@Service
public class LikeService 
{
	private IUserDao ud;
	private IMessageDao md;
	private ILikeDao ld;
	
	@Autowired
	public LikeService(ILikeDao ld) {
		super();
		this.ld = ld;
	}
	
	
	public List<Like> getLikesByUserId(int userId)
	{
		return ld.getLikesByUserId(userId);
	}
	
	public List<Like> getLikesByMessageId(int messageId)
	{
		return ld.getLikesByUserId(messageId);
	}
	
	public void create(int userId, int msgId)
	{
		Like l = new Like(ud.getUser(userId), md.getMessage(msgId));
		ld.createLike(l);
	}
	
	public void delete(int id)
	{
		Like l = new Like();
		l.setId(id);
		ld.deleteLike(l);
	}
}
