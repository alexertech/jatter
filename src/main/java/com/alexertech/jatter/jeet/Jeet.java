package com.alexertech.jatter.jeet;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * The Jeet Class models the Jeets, which would be the equivalent to Tweets.
 * Each message is attached to a user. 
 * Note that this class also handles the setup up of the database tables.
 * */

@Document(collection = "jeet")
public class Jeet {
	@Id
	private int jeetId;	
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	  
	private String message;

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

}