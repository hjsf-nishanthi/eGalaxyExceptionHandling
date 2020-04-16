package com.egalaxy.user.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egalaxy.user.entity.User;
import com.egalaxy.exception.ResourceNotFoundException;
import com.egalaxy.user.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/all")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping(value = "/add",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping(value = "/update/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") long userId, 
	@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
    User user = UserRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

    user.setUserEmail(userDetails.getUserEmail());
    user.setUserName(userDetails.getUserName());
    user.setUserPassword(userDetails.getUserPassword());
	user.setUserDob(userDetails.getUserDob());
	user.setUserGender(userDetails.getUserGender());
    final user updatedUser = UserRepository.save(user);
    return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping(value= "/deleteAll")
	public void deleteBooks() {
		userService.deleteAllUsers();
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteBook(@PathVariable(value = "id") long userId) 
	throws ResourceNotFoundException {
    User user = UserRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	UserRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
	}

	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<User> getOneCustomer(@PathVariable(value = "id") long userId)
	throws ResourceNotFoundException{
		User user = UserRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
}
