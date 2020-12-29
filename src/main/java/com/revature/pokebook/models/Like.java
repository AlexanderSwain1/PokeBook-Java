package com.revature.pokebook.models;

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
	
	
}
