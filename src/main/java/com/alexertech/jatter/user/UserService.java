package com.alexertech.jatter.user; 

import java.util.List;

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

}
