package cn.itcast.text;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
  @Test
  public void fun(){
	     ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	   User uu=  (User) ac.getBean("user");
	   User u1=  (User) ac.getBean("user");
	   User u2=  (User) ac.getBean("user");
	   System.out.println(uu);
  }
 
@Test
  public void fun1(){
	  ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	  ac.close();
  }
}
