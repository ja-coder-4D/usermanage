package com.test.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.test.dao.UserDao;
import com.test.model.User;

public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private UserDao userDao;
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public List<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public User getOne(Integer id) {
		// TODO Auto-generated method stub
		return userDao.getOne(id);
	}

	@Override
	public Page<User> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends User> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return userDao.findOne(arg0);
	}

	@Override
	public <S extends User> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByPhoneNotNull() {
		return userDao.findByPhoneNotNull();
	}

	@Override
	public List<User> findByUserNameLike(String userName) {
		return userDao.findByUserNameLike(userName);
	}

	@Override
	public List<User> findByUserNameNotLike(String userName) {
		return userDao.findByUserNameNotLike(userName);
	}

	@Override
	public List<User> findByUserNameNotLikeAndPhoneNotNull(String userName) {
		return userDao.findByUserNameNotLikeAndPhoneNotNull(userName);
	}

	@Override
	public List<User> findByUserNameStartingWith(String userName) {
		return userDao.findByUserNameStartingWith(userName);
	}

	@Override
	public List<User> findByUserNameEndingWith(String userName) {
		return userDao.findByUserNameEndingWith(userName);
	}

	@Override
	public List<User> findByUserNameContaining(String userName) {
		return userDao.findByUserNameContaining(userName);
	}

	@Override
	public Page<User> findByUserNameLike(String userName, Pageable pageable) {
		return userDao.findByUserNameLike(userName, pageable);
	}

	@Override
	public List<User> findUserByUserNameLikeAndAge(String userName, int age) {
		return userDao.findUserByUserNameLikeAndAge(userName, age);
	}

	@Override
	public List<User> findUserByAge(int age) {
		return userDao.findUserByAge(age);
	}

	@Override
	public List<Object[]> findUserWithGroupBy() {
		return userDao.findUserWithGroupBy();
	}

	@Override
	public User findUserById(int id) {
		
		return entityManager.find(User.class, id);
	}

}
