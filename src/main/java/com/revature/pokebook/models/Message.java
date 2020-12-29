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
	
	@Column(name = "pokemon_id")
	private int pokemonId;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "message_post_time")
	private Timestamp messagePostTime;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private int authorId;
	
	
	@Column(name="likes")
	private int likes;
	
	
}
