package com.alexertech.jatter.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alexertech.jatter.user.Users;
import com.alexertech.jatter.user.UserRepository;

@Service
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
        	
        	/*
            return User.builder()
            	.username(users.getUsername())
            	.password(users.getPassword())
            	.build();
            */
            

			List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
            return new org.springframework.security.core.userdetails
            		.User(users.getUsername(), users.getPassword(), authorities);
            
        } else {
        	System.out.println("User Name is not Found");
        	throw new UsernameNotFoundException("User Name is not Found");
        }   
    }
}
