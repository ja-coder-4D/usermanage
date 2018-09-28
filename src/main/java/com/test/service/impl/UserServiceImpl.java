package com.test.service.impl;

import java.util.List;

import javax.xml.soap.SAAJResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.exception.UserNotFound;
import com.test.model.User;
import com.test.service.UserService;
/**
 * @author win
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
	private UserDao userDao;
    //添加用户
    @Override
	public void addUser(User user) {
		userDao.save(user);
	}
    
    //修改用户
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
	
	//删除用户,根据编号
	@Override
	public User deleteUser(int id) throws UserNotFound {
		User deleteUser = userDao.findOne(id);
		if (deleteUser == null) {
			throw new UserNotFound();
		}
		userDao.delete(deleteUser);
		return deleteUser;
	}
	
	//查询单个用户
	@Override
	public User getUser(int id) {
		return userDao.findOne(id);
	}
	
	//查询所有用户
	@Override
	public List<User> getUsers() {	
		return userDao.findAll();
	}
	
	//查询phone不为空的
	@Override
	public List<User> findUserByPhoneIsNotNull() {
		return userDao.findByPhoneNotNull();
	}
	
	//模糊查询like
	@Override
	public List<User> findUserLikeUserName(String userName) {	
		return userDao.findByUserNameLike("%"+userName+"%");
	}
	
	//模糊查询notlike
	@Override
	public List<User> findUserNotLikeUserName(String userName) {
		return userDao.findByUserNameNotLike("%" + userName + "%");
	}
	
	//模糊查询notlike增加判断phone不为空的
	@Override
	public List<User> findUserByUserNameNotLikeAndPhoneNotNull(String userName) {
		return userDao.findByUserNameNotLikeAndPhoneNotNull("%" + userName + "%");
	}
	
	//StartingWith
	@Override
	public List<User> findUserByUserNameStartingWith(String userName) {	
	   return userDao.findByUserNameStartingWith(userName);
	}
    
	//EndingWith
	@Override
	public List<User> findUserByUserNameEndingWith(String userName) {
		return userDao.findByUserNameEndingWith(userName);
	}
    
	//Containing
	@Override
	public List<User> findUserByUserNameContaining(String userName) {
		return userDao.findByUserNameContaining(userName);
	}

	@Override
	public Page<User> findUserLikeUserNameWithPage(String userName,
			Integer page, Integer pageSizde) {
		return userDao.findByUserNameLike("%"+userName + "%", new PageRequest(page, pageSizde,new Sort(Direction.DESC, "age")));
	}

	@Override
	public List<User> findUserByUserNameAndAge(String userName, int age) {
		return userDao.findUserByUserNameLikeAndAge(userName, age);
	}

	@Override
	public List<User> findUserByAge(int age) {
		return userDao.findUserByAge(age);
	}

	/*@Override
	public List<User> findUserWithGroupBy() {
		return userDao.findUserWithGroupBy();
	}*/
	
  
}
