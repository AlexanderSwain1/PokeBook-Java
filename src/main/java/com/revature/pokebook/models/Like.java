package com.revature.pokebook.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Likes")
public class Like 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="like_id")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private int userId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "message_id")
	private int messageId;

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int id, int userId, int messageId) {
		super();
		this.id = id;
		this.userId = userId;
		this.messageId = messageId;
	}

	public Like(int userId, int messageId) {
		super();
		this.userId = userId;
		this.messageId = messageId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, messageId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Like other = (Like) obj;
		return id == other.id && messageId == other.messageId && userId == other.userId;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", userId=" + userId + ", messageId=" + messageId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
}