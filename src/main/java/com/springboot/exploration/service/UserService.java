package com.springboot.exploration.service;

import java.util.List;

import com.springboot.exploration.model.User;

/**
 * Class defines the service for user
 * 
 * @author Naveen Tyagi
 *
 */
public interface UserService {

	/**
	 * Method to add the user
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * Method to get the user by id.
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(Long id);

	/**
	 * Method to delete the user by id
	 * 
	 * @param id
	 * @return
	 */
	public User deleteById(Long id);

	/**
	 * Method returns the list of all the user
	 * 
	 * @return
	 */
	public List<User> getUsers();

	/**
	 * Method to update the User
	 * 
	 * @param user
	 * @return
	 */
	public User update(User user);

	/**
	 * Method to authenticate the user
	 * 
	 * @param user
	 * @return
	 */
	public boolean authenticate(User user);
}
