package com.sr.mycart.service;

import javax.servlet.http.HttpSession;

import com.sr.mycart.Dao.UserDao;
import com.sr.mycart.dto.User;

public class UserService {

	UserDao userDao = new UserDao();

//	public User saveuser(User user) {
//
//		return userDao.saveUser(user);

	//}
	
	//public class UserService {
	 //   private UserDao userDao;

	    public UserService() {
	        userDao = new UserDao();
	    }

	    public boolean isUserDataValid(User user) {
	        // Check if any of the user data fields are empty or null
	        return user.getUserName() != null && !user.getUserName().isEmpty()
	                && user.getUserEmail() != null && !user.getUserEmail().isEmpty()
	                && user.getUserPassword() != null && !user.getUserPassword().isEmpty()
	                && user.getUserPhone() != null && !user.getUserPhone().isEmpty()
	                && user.getUserAddress() != null && !user.getUserAddress().isEmpty();
	    }

	    public void saveUser(User user) {
	        if (isUserDataValid(user)) {
	            userDao.saveUser(user);
	        } else {
	            throw new IllegalArgumentException("Please enter all user data");
	        }
	    }
//	}


	public User updateUser(User user) {
		return userDao.saveUser(user);
	}

	public User getUserByEmailAndPassword(String email, String password) {
		User user = userDao.getUserByEmailAndPassword(email, password);
		return user;

//		if (user.getUserEmail().equals(email) && user.getUserPassword().equals(password)) {
//			return user;
//		} else if(!user.getUserEmail().equals(email) && user.getUserPassword().equals(password)) {
//			return null;
//		}else 
//			return null;
		

	}
	
	
}
