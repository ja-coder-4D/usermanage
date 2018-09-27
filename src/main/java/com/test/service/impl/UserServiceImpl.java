package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.exception.UserNotFound;
import com.test.model.User;
import com.test.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDao userDao;
	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public User updateUser(User user) throws UserNotFound {
		User updateUser = userDao.findOne(user.getId());
		if (updateUser == null) {
			throw new UserNotFound();
		} 
		if (user != null) {
			updateUser.setUserName(user.getUserName());	
			updateUser.setAge(user.getAge());
		}
		userDao.save(updateUser);
		return updateUser;
	}

	@Override
	public User deleteUser(int id) throws UserNotFound {
		User deleteUser = userDao.findOne(id);
		if (deleteUser == null) {
			throw new UserNotFound();
		}
		userDao.delete(deleteUser);
		return deleteUser;
	}

	@Override
	public User getUser(int id) {
		return userDao.findOne(id);
	}

	@Override
	public List<User> getUsers() {	
		return userDao.findAll();
	}

	@Override
	public List<User> findUserByPhoneIsNotNull() {
		return userDao.findByPhoneNotNull();
	}

	@Override
	public List<User> findUserLikeUserName(String userName) {	
		return userDao.findByUserNameLike("%"+userName+"%");
	}

	@Override
	public List<User> findUserNotLikeUserName(String userName) {
		return userDao.findByUserNameNotLike("%" + userName + "%");
	}

	@Override
	public List<User> findUserByUserNameNotLikeAndPhoneNotNull(String userName) {
		return userDao.findByUserNameNotLikeAndPhoneNotNull("%" + userName + "%");
	}

}
