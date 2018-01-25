package org.com.ideabytes.service.bean;

import java.util.List;

import javax.transaction.Transactional;

import org.com.ideabytes.model.UserDetails;
import org.com.ideabytes.model.repository.UserDetailsRepository;
import org.com.ideabytes.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
@Transactional
public class UserDetailsServiceBean implements UserDetailsService {
	
	 @Autowired
	 private UserDetailsRepository userDetailRepository;
	
	 public UserDetails findById(Long id) {
	        return userDetailRepository.findOne(id);
	    }
	 
	    public UserDetails findByUserName(String name) {
	        return userDetailRepository.findByUserName(name);
	    }
	 
	    public void saveUserDetails(UserDetails user) {
	    	userDetailRepository.save(user);
	    }
	 
	    public void updateUserDetails(UserDetails user){
	        saveUserDetails(user);
	    }
	 
	    public void deleteUserDetailsById(Long id){
	    	userDetailRepository.delete(id);
	    }
	 
	    public void deleteAllUsersDetails(){
	    	userDetailRepository.deleteAll();
	    }
	 
	    public List<UserDetails> findAllUserDetails(){
	        return userDetailRepository.findAll();
	    }
	 
	    public boolean isUserExist(UserDetails user) {
	        return findByUserName(user.getUsername()) != null;
	    }

		@Override
		public void deleteAllUserDetails() {
			// TODO Auto-generated method stub
			
		}

}
