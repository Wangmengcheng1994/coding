package cn.itcast.d_springaop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.service.UserService;
import cn.itcast.service.UserServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/itcast/d_springaop/applicationContext.xml")
public class Demo {
		@Resource(name="userService")
	private UserService us;
		@Test
		public void fun1(){
			System.out.println(us);
			us.save();
		}

}
