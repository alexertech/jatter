package com.alexertech.jatter.jeet;

import java.util.List;
import java.util.Optional;

public interface JeetInterface {
	
	public List<Jeet>GetAll();
	public Optional<Jeet>GetId(int id);
	public int Save(Jeet i);
	public void Delete(int id);

}
