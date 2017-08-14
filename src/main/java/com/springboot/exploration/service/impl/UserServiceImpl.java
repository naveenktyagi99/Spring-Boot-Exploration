package com.springboot.exploration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exploration.dao.UserDao;
import com.springboot.exploration.model.User;
import com.springboot.exploration.service.UserService;

/**
 * Class provides the user services implementation
 * 
 * @author naveen.tyagi
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUser(Long id) {
		return null;
	}

	@Override
	public User deleteById(Long id) {
		return null;
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public boolean authenticate(User user) {
		return userDao.authenticate(user);
	}
}
