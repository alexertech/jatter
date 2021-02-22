package com.alexertech.jatter.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {

	Optional<Users> findByUsername(String username);

}
