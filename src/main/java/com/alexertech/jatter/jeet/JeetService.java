package com.alexertech.jatter.jeet;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JeetService implements JeetInterface {

	@Autowired
	private JeetRepository data;
	
	@Override
	public List<Jeet> GetAll() {
		return (List<Jeet>)data.findAll();
	}

	@Override
	public int Save(Jeet i) {
		int res=0;
		Jeet issue = data.save(i);
		if (!issue.equals(null)) {
			res=1;
		}
		
		return res;
	}

	@Override
	public Optional<Jeet> GetId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}


}
