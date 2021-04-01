package com.alexertech.jatter.jeet;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JeetRepository extends MongoRepository<Jeet, String> {

	void deleteById(int id);

	Optional<Jeet> findById(int id);
	
}
