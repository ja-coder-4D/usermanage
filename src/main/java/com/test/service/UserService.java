package com.test.service;

import java.util.List;

import com.test.exception.UserNotFound;
import com.test.model.User;

public interface UserService {
	//添加用户
	public void addUser(User user);
	//修改用户
	public User updateUser(User user) throws UserNotFound;
	//删除用户,根据编号
	public User deleteUser(int id) throws UserNotFound;
	//查询单个用户
	public User getUser(int id);
	//查询所有用户
	public List<User> getUsers();
	//查询phone不为空的
	public List<User> findUserByPhoneIsNotNull();
	//模糊查询like
	public List<User> findUserLikeUserName(String userName);
	//模糊查询notlike
	public List<User> findUserNotLikeUserName(String userName);
	//模糊查询notlike增加判断phone不为空的
	public List<User> findUserByUserNameNotLikeAndPhoneNotNull(String userName);
}
