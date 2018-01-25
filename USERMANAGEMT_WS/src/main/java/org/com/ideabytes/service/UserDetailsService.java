package org.com.ideabytes.service;

import java.util.List;

import org.com.ideabytes.model.UserDetails;


public interface UserDetailsService {

	UserDetails findById(Long id);

	UserDetails findByUserName(String name);

	void saveUserDetails(UserDetails user);

	void updateUserDetails(UserDetails user);

	void deleteUserDetailsById(Long id);

	void deleteAllUserDetails();

	List<UserDetails> findAllUserDetails();

	boolean isUserExist(UserDetails user);
}
