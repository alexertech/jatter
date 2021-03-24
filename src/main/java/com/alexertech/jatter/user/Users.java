package com.alexertech.jatter.user;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alexertech.jatter.jeet.Jeet;

/*
 * The Users Class models the Users. This class works very closely with SpringSecurity and uses
 * a Plural name because the security framework has a class called User  
 * 
 * Note that this class also handles the setup up of the database tables.
 * */

@Document(collection = "user")
public class Users {
	
	@Id
	private String id;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	private String username;
	private String password;
	@DBRef
	List<Jeet> jeets;

	public int getUserId() {
		return getUserId();
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
