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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Follows")
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString @AllArgsConstructor
public class Follow 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "follow_id")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "pokemon_id")
	private int pokemonId;
	
	public Follow(User user, int pokemonId) {
		this.user = user;
		this.pokemonId = pokemonId;
	}
}
