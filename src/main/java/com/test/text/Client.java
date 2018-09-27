package com.test.text;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.model.User;
import com.test.service.UserService;

public class Client {
	  @Autowired
	  private static UserService userService;
	  public static void printUsers(User user) {
		  StringBuilder stringBuilder = new StringBuilder();
		  stringBuilder.append("ID = " + user.getId());
		  stringBuilder.append("userName = " + user.getUserName());
		  stringBuilder.append("age = " + user.getAge());
		  System.out.println(stringBuilder.toString());
	  }
	
	public static void testList(UserService userService){
		  List<User> users =  userService.getUsers();
		  if (users != null) {
			  for (int i = 0; i < users.size(); i++) {
				printUsers(users.get(i));
			}
		 }
	  }
      public static void main(String[] args) {
		
		 testList(userService);
	  }
}
