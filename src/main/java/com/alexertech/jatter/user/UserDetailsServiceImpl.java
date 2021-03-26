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
	
    // Locates the user based on the username. We override this in the function in the Spring Security 
    // UserDetailsService class.
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Users> optionalUser = usersRepository.findByUsername(userName);
        
        // If the user is present we copy the data to an object.
        if(optionalUser.isPresent()) {
        	Users users = optionalUser.get();
        	           
        	// Stores a String representation of an authority granted to the Authentication object.
        	// Here we can implement roles, however to keep it simple will use a single role called "user"
			List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
			
			// Returns the user details and grants the access
            return new org.springframework.security.core.userdetails
            		.User(users.getUsername(), users.getPassword(), authorities);
            
            // TODO: Research the section of the class where the password is being compared
            
        } else {
        	throw new UsernameNotFoundException("User Name is not Found");
        }   
    }
}
