package com.test.text;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.exception.UserNotFound;
import com.test.model.User;
import com.test.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpaTest {
    @Autowired
	private UserService userService;
    //打印集合到控制台
    public static void printListUser(List<User> users) {
    	if (users != null) {
			for (int i = 0; i < users.size(); i++) {
				printUsers(users.get(i));
			}
		}
    }
    //打印在控制台
    public static void printUsers(User user) {
		  StringBuilder stringBuilder = new StringBuilder();
		  stringBuilder.append("ID = " + user.getId() +"\t");
		  stringBuilder.append("userName = " + user.getUserName() + "\t\t");
		  stringBuilder.append("age = " + user.getAge() + "\t");
		  stringBuilder.append("code = " + user.getCode() + "\t");
		  stringBuilder.append("phone = " + user.getPhone() + "\t");
		  System.out.println(stringBuilder.toString());
	  }
    //测试查询
    public static void testList(UserService userService){
		  List<User> users =  userService.getUsers();
		  if (users != null) {
			  for (int i = 0; i < users.size(); i++) {
				printUsers(users.get(i));
			}
		 }
	  }
    //测试修改
    public static void testUpdate(UserService userService) throws UserNotFound {
    	User user = new User();
    	user.setId(1);
    	user.setAge(66);
    	userService.updateUser(user);
    	testList(userService);
    }
    //测试增加
    public static void testAdd(UserService userService) {
    	for (int i = 1; i <5; i++) {
    		User user = new User();
        	user.setUserName("保姆" + i);
        	user.setAge(20 + i);
        	userService.addUser(user);
		}
    	
       testList(userService);
    }
    //测试删除
    public static void testDelete(UserService userService) throws UserNotFound{
    	userService.deleteUser(34);
    	testList(userService);
    }
    //测试查询phone不为空的
    public static void testFindUsersByPhoneIsNotNull(UserService userService){
    	List<User> users = userService.findUserByPhoneIsNotNull();
    	printListUser(users);
    }
   
	@Test
	public void test() throws UserNotFound {
		//testList(userService);
		//testUpdate(userService);
		//testAdd(userService);
        //testDelete(userService);
		testFindUsersByPhoneIsNotNull(userService);
	}
	 //测试模糊查询like
	@Test
    public  void testFindUsersByUserNameLike(){
    	List<User> users = userService.findUserLikeUserName("小米");
    	printListUser(users);
    }
	 //测试模糊查询notlike
	@Test
	public void testFindUsersByUserNameNotLike(){
		List<User> users = userService.findUserNotLikeUserName("小米");
		printListUser(users);
	}
	//测试模糊查询notlike增加判断phone不为空的
	@Test
	public void testfindUserByUserNameNotLikeAndPhoneNotNull(){
		List<User> users = userService.findUserByUserNameNotLikeAndPhoneNotNull("小米");
		printListUser(users);
	}
}
