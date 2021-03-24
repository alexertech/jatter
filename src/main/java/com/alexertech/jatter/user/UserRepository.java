package com.alexertech.jatter.user;


import com.alexertech.jatter.user.Users;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * The UsersRepository Class handles all the interactions with the database, in this case
 * extends from the MongoRepository since our database backend is MongoDB. This could change
 * to CRUD or JPA depending of which database is used.
 * */

public interface UserRepository extends MongoRepository<Users, String> {

	// Required for SpringSecurity, we need to find a users with Username
	Optional<Users> findByUsername(String username);

}
