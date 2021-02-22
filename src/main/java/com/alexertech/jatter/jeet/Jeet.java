package com.alexertech.jatter.jeet;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jeets")
public class Jeet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jeetId;	
	private String message;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users", joinColumns = @JoinColumn(name = "jeetId"), 
	inverseJoinColumns = @JoinColumn(name = "userId"))
	List<Jeet> jeets;

	public int getJeetId() {
		return jeetId;
	}

	public void setJeetId(int jeetId) {
		this.jeetId = jeetId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Jeet> getJeets() {
		return jeets;
	}

	public void setJeets(List<Jeet> jeets) {
		this.jeets = jeets;
	}



}