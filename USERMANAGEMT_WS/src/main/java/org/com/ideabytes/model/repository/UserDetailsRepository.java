package org.com.ideabytes.model.repository;


import org.com.ideabytes.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDetailsRepository  extends JpaRepository<UserDetails, Long> {
	
	UserDetails findByUserName(String name);

}