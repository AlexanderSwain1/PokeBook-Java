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

	private ILikeDao ld;
	private IUserDao ud;
	private IMessageDao md;
	
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
	
	public boolean create(Like like) //Ask Gabriel if these checks break anything
	{
		if(like.getUser().getId() <= 0) {
			return false;
		} else if(like.getMessage().getId() <= 0) {
			return false;
		}
		User user = ud.getUser(like.getUser().getId());
		Message message = md.getMessage(like.getMessage().getId()); //Could be reduced to two lines
		Like l = new Like(user, message);
		return ld.createLike(l);
	}
	
	public boolean delete(Like like)
	{
		return ld.deleteLike(like);
	}
}
