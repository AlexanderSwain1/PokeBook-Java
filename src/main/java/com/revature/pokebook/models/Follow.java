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
@Table(name = "Follows")
public class Follow 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "follow_id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private int userId;
	
	@Column(name = "pokemon_id")
	private int pokemonId;

	
	public Follow() {
		super();
	}
	public Follow(int userId, int pokemonId) {
		super();
		this.userId = userId;
		this.pokemonId = pokemonId;
	}
	public Follow(int id, int userId, int pokemonId) {
		super();
		this.id = id;
		this.userId = userId;
		this.pokemonId = pokemonId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, pokemonId, userId);
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
		Follow other = (Follow) obj;
		return id == other.id && pokemonId == other.pokemonId && userId == other.userId;
	}
	@Override
	public String toString() {
		return "Follow [id=" + id + ", userId=" + userId + ", pokemonId=" + pokemonId + "]";
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
	public int getPokemonId() {
		return pokemonId;
	}
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}
}