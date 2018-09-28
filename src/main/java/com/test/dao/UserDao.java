package com.test.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


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
    //StartingWith
    public List<User> findByUserNameStartingWith(String userName);
    //EndingWith
    public List<User> findByUserNameEndingWith(String userName);
    //Containing
    public List<User> findByUserNameContaining(String userName);
    //排序
   // public List<User> findByUserNameLike(String userName,Sort sort);
    //分页
    public Page<User> findByUserNameLike(String userName,Pageable pageable);
    
    @Query(value = "select u from User u where u.userName =?1 and u.age =?2 ")
    public List<User> findUserByUserNameLikeAndAge(String userName,int age);
    
    @Query(value = "select u from User u where u.age = ?1")
    public List<User> findUserByAge(int age);
    
/*    @Query(value = "select u.age,count(*) from User u group by u.age")
    public List<User> findUserWithGroupBy();*/
}
