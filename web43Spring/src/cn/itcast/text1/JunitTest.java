package cn.itcast.text1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.text.User;

//执行junit测试方法是自动创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring 容器的配置文件路径
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
     @Resource(name="user")
     //在Junit测试中使用@Resource不需要开启context：component—scan
	 private User user;
     
	@Test
	public void fun2(){
		System.out.println(user);
	}
}
