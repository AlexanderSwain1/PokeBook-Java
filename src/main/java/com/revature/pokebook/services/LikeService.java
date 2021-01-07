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
import com.revature.pokebook.models.Message;
import com.revature.pokebook.models.User;

@Service
public class LikeService 
{
	private IUserDao ud;
	private IMessageDao md;
	private ILikeDao ld;
	
	@Autowired
	public LikeService(ILikeDao ld, IUserDao ud, IMessageDao md) {
		super();
		this.ld = ld;
		this.ud = ud;
		this.md = md;
	}
	
	
	public List<Like> getLikesByUserId(int userId)
	{
		return ld.getLikesByUserId(userId);
	}
	
	public List<Like> getLikesByMessageId(int messageId)
	{
		return ld.getLikesByUserId(messageId);
	}
	
	public void create(Like like)
	{
		User user = ud.getUser(like.getUser().getId());
		Message message = md.getMessage(like.getMessage().getId());
		Like l = new Like(user, message);
		ld.createLike(l);
	}
	
	public void delete(Like like)
	{
		//Like l = new Like();
		//l.setId(id);
		ld.deleteLike(like);
	}
}
