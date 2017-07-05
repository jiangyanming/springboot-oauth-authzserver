package com.company.oauth.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.company.oauth.model.User;

@Service("userDetailsSvc")
public class UserDetailsServiceLocalImpl implements UserDetailsService{

	private static final Logger logger = Logger.getLogger(UserDetailsServiceLocalImpl.class.getName());
	
	private static Map<String, UserDetails> userMap;
	
	static {
		userMap = new HashMap<String, UserDetails>();

		User user1 = new User();
		user1.setUsername("user1");
		user1.setPassword("password1");
		user1.setEnabled(true);
		userMap.put(user1.getUsername(), user1);
		logger.log(Level.INFO, "User 1 : " + user1);

		User user2 = new User();
		user2.setUsername("user2");
		user2.setPassword("password2");
		user2.setEnabled(true);
		userMap.put(user2.getUsername(), user2);
		logger.log(Level.INFO, "User 2 : " + user2);

	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userMap.get(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return user;
	}

}
