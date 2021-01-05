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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Messages")
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString @AllArgsConstructor
public class Message implements Comparable<Message>
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="message_id")
	private int id;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User author;
	
	@Column(name = "pokemon_id")
	private int pokemonId;
	
	@Column(name = "message_post_time")
	private Timestamp messagePostTime;
	
	@Override
	public int compareTo(Message m) {
		if (getMessagePostTime() == null || m.getMessagePostTime() == null) {
		return 0;
	}
		return getMessagePostTime().compareTo(m.getMessagePostTime());
	}
}