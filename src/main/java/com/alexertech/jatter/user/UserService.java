package com.alexertech.jatter.user; 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserInterface {

	@Autowired
	private UserRepository data;

	@Override
	public List<Users> GetAll() {
		return (List<Users>)data.findAll();
	}

	@Override
	public Optional<Users> GetId(int id) {
		return null;
	}

	@Override
	public Optional<Users> GetByUsername(String username) {
		return data.findByUsername(username);
	}

}