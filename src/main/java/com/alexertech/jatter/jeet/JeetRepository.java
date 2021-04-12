package com.alexertech.jatter.jeet;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JeetRepository extends MongoRepository<Jeet, String> {
	
}
