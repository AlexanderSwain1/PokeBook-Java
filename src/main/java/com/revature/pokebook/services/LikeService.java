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
	
	public LikeService() {
		super();
	}
	
	public List<Like> getLikesByUserId(int userId)
	{
		if(userId <= 0) {
			return null;
		}
		return ld.getLikesByUserId(userId);
	}
	
	public List<Like> getLikesByMessageId(int messageId)
	{
		if(messageId <= 0) {
			return null;
		}
		return ld.getLikesByUserId(messageId);
	}
	
	public boolean create(Like like)
	{
		User user = ud.getUser(like.getUser().getId());
		Message message = md.getMessage(like.getMessage().getId());
		Like l = new Like(user, message);
		ld.createLike(l);
		return true;
	}
	
	public boolean delete(Like like)
	{
		if(like.getId() <= 0) {
			return false;
		} else if(like.getMessage().getId() <= 0) {
			return false;
		} else if(like.getUser().getId() <= 0) {
			return false;
		}
		ld.deleteLike(like);
		return true;
	}
}
