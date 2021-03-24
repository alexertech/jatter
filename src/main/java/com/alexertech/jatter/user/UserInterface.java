package com.alexertech.jatter.user;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
	
	public List<Users>GetAll();
	public Optional<Users>GetId(int id);
	public Optional<Users> GetByUsername(String username);

}