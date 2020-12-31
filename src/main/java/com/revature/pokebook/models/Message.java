package com.revature.pokebook.models;

import java.sql.Timestamp;

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
@Table(name = "Messages")
public class Message 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="message_id")
	private int id;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private int authorId;
	
	@Column(name = "pokemon_id")
	private int pokemonId;
	
	@Column(name = "message_post_time")
	private Timestamp messagePostTime;

	public Message(int id, String content, int authorId, int pokemonId, Timestamp messagePostTime) {
		super();
		this.id = id;
		this.content = content;
		this.authorId = authorId;
		this.pokemonId = pokemonId;
		this.messagePostTime = messagePostTime;
	}

	public Message(String content, int authorId, int pokemonId, Timestamp messagePostTime) {
		super();
		this.content = content;
		this.authorId = authorId;
		this.pokemonId = pokemonId;
		this.messagePostTime = messagePostTime;
	}

	public Message() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	public Timestamp getMessagePostTime() {
		return messagePostTime;
	}

	public void setMessagePostTime(Timestamp messagePostTime) {
		this.messagePostTime = messagePostTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + ((messagePostTime == null) ? 0 : messagePostTime.hashCode());
		result = prime * result + pokemonId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (authorId != other.authorId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (messagePostTime == null) {
			if (other.messagePostTime != null)
				return false;
		} else if (!messagePostTime.equals(other.messagePostTime))
			return false;
		if (pokemonId != other.pokemonId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", authorId=" + authorId + ", pokemonId=" + pokemonId
				+ ", messagePostTime=" + messagePostTime + "]";
	}
	
	
}
