package com.alexertech.jatter.user;

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

import com.alexertech.jatter.jeet.Jeet;


/*
 * The Users Class models the Users. This class works very closely with SpringSecurity and uses
 * a Plural name because the security framework has a class called User  
 * 
 * Note that this class also handles the setup up of the database tables.
 * */

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;	
	@Column(unique=true)
	private String username;
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "jeets", joinColumns = @JoinColumn(name = "userId"), 
	inverseJoinColumns = @JoinColumn(name = "jeetId"))
	List<Jeet> jeets;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Jeet> getJeets() {
		return jeets;
	}

	public void setJeets(List<Jeet> jeets) {
		this.jeets = jeets;
	}


}
