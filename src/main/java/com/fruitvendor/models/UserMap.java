package com.fruitvendor.models;

import java.util.HashMap;
import java.util.Map;

import com.fruitvendor.entities.User;

public class UserMap {
private static Map<String, User> usersOfStore = new HashMap<>();
	
	public UserMap() {
		// TODO Auto-generated constructor stub
		this.initializeUsers();
	}
	
	// initialize users of store
	void initializeUsers() {
		String[] userNames = { "sharath", "vinay" };
		String[] userPasswords = { "123", "321" };
		for (int index = 0; index < userNames.length; index++) {
			usersOfStore.put(userNames[index], new User(userNames[index], userPasswords[index]));
		}
	}

	// Check if user is valid
	public boolean isUserValid(String userName, String password) {
		User currentUser = usersOfStore.get(userName);
		String currentUserPassword = currentUser.getUserPassword();
		if (password.equals(currentUserPassword))
			return true;
		return false;
	}
	
	//Add user to Map
	public User addNewUser(String userName, String password) {
		User newUser = new User(userName,password);
		usersOfStore.put(userName, newUser);
		return newUser;
	}
	
	public User getUserCredentials(String userName) {
		return usersOfStore.get(userName);
	}
}
