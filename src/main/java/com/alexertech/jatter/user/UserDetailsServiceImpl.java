package com.alexertech.jatter.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.alexertech.jatter.jeet.Jeet;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;
	
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	   	
        Optional<Users> optionalUser = usersRepository.findByUsername(userName);
        
        if(optionalUser.isPresent()) {
        	Users users = optionalUser.get();
        	
        	List<String> JeetList = new ArrayList<String>();
        	for(Jeet jeet:users.getJeets()) {
        		JeetList.add(jeet.getMessage());
        	}
        	
            return User.builder()
            	.username(users.getUsername())
            	.password(users.getPassword())
            	.roles(JeetList.toArray(new String[0]))
            	.build();
        } else {
        	System.out.println("User Name is not Found");
        	throw new UsernameNotFoundException("User Name is not Found");
        }   
    }
}
