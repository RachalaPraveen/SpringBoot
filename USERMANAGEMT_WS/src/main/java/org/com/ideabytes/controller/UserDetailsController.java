package org.com.ideabytes.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.MediaType;
import org.com.ideabytes.exception.PrepareResonce;
import org.com.ideabytes.exception.EntityNotFoundException;
import org.com.ideabytes.model.UserDetails;
import org.com.ideabytes.service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
@RestController
@RequestMapping("/api")
public class UserDetailsController {
    public static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);
    
    @Autowired
    UserDetailsService userDetailsService; //Service which will do all data retrieval/manipulation work
    
    // -------------------Retrieve All Users---------------------------------------------
 
    @RequestMapping(value = "/user_details/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<UserDetails>> listAllUsers() throws EntityNotFoundException{
        List<UserDetails> users = userDetailsService.findAllUserDetails();
        
        if (users.isEmpty()) {
        	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single User------------------------------------------
 
    @RequestMapping(value = "/user_details/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@PathVariable("id") long id)  throws EntityNotFoundException{
        logger.info("Fetching User with id {}", id);
        UserDetails user = userDetailsService.findById(id);
        if (user == null) {
        	 logger.error("User with id {} not found.", id);
             return new ResponseEntity<>(new PrepareResonce("User with id " + id 
                     + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
 
    // -------------------Create a User-------------------------------------------
 
    @RequestMapping(value = "/user_details/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserDetails user, UriComponentsBuilder ucBuilder)  throws EntityNotFoundException {
        logger.info("Creating User : {}", user);
 
        if (userDetailsService.isUserExist(user)) {
        	logger.error("Unable to create. A User with name {} already exist", user.getLastName());
            return new ResponseEntity<>(new PrepareResonce("Unable to create. A User with name " + 
            user.getLastName() + " already exist."),HttpStatus.CONFLICT);
        }
        userDetailsService.saveUserDetails(user);
        
        return new ResponseEntity<>(new PrepareResonce("User Created Successfully"),HttpStatus.CREATED);
    }
 
    // ------------------- Update a User ------------------------------------------------
 
    @RequestMapping(value = "/user_details/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserDetails user)  throws EntityNotFoundException{
        logger.info("Updating User with id {}", id);
 
        UserDetails currentUser = userDetailsService.findById(id);
 
        if (currentUser == null) {
        	logger.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity<>(new PrepareResonce("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentUser.setUsername(user.getFirstName());
        currentUser.setPassword(user.getPassword());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhone(user.getPhone());
        currentUser.setCountry(user.getCountry());
        currentUser.setUserType(user.getUserType());
        currentUser.setDgCertificate(user.getDgCertificate());
      
        userDetailsService.updateUserDetails(currentUser);
        return new ResponseEntity<>(new PrepareResonce("User Updated Successfully"),HttpStatus.OK);
       // return new ResponseEntity<UserDetails>(currentUser, HttpStatus.OK);
    }
 
    // ------------------- Delete a User-----------------------------------------
 
    @RequestMapping(value = "/user_details/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) throws EntityNotFoundException{
        logger.info("Fetching & Deleting User with id {}", id);
 
        UserDetails user = userDetailsService.findById(id);
        if (user == null) {
        	 logger.error("Unable to delete. User with id {} not found.", id);
             return new ResponseEntity<>(new PrepareResonce("Unable to delete. User with id " + id + " not found."),
                     HttpStatus.NOT_FOUND);
        }
        userDetailsService.deleteUserDetailsById(id);
       // return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(new PrepareResonce("User Deleted Successfully"),HttpStatus.OK);
    }
 
    // ------------------- Delete All Users-----------------------------
 
    @RequestMapping(value = "/user_details/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteAllUsers()  throws EntityNotFoundException{
        logger.info("Deleting All Users");
 
        userDetailsService.deleteAllUserDetails();
        return new ResponseEntity<>(new PrepareResonce("User Deleted Successfully"),HttpStatus.NO_CONTENT);
    }
 
}
