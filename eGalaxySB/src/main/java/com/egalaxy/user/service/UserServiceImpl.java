package com.egalaxy.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egalaxy.user.entity.User;
import com.egalaxy.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<User> getUserById(int userId) {
		return userRepository.findById((long) userId);
	}

	@Override
	@Transactional
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		long uid = userId;
		userRepository.deleteById(uid);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void addUser(User user) {
		userRepository.save(user);
	}

}
