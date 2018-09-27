package com.test.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.User;

public interface UserDao  extends JpaRepository<User, Integer>{
    //查询phone不为空的
	public List<User> findByPhoneNotNull();
	//模糊查询like
    public List<User> findByUserNameLike(String userName);
    //模糊查询notlike
    public List<User> findByUserNameNotLike(String userName);
    //模糊查询notlike增加判断phone不为空的
    public List<User> findByUserNameNotLikeAndPhoneNotNull(String userName);
}
