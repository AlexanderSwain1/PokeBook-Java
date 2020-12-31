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
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "like_id")
	private String messageId;


	public Like() {
		super();
	}
	public Like(String messageId) {
		super();
		this.messageId = messageId;
	}
	public Like(int id, String messageId) {
		super();
		this.id = id;
		this.messageId = messageId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, messageId);
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
		return id == other.id && Objects.equals(messageId, other.messageId);
	}
	@Override
	public String toString() {
		return "Like [id=" + id + ", messageId=" + messageId + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
}