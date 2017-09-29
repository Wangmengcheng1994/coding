package cn.itcast.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;







@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/itcast/aop/applicationContext.xml")
public class Demo {
		@Resource(name="userService")
	private UserService us;
		@Test
		public void fun1(){
			System.out.println(us);
			us.save();
		}

}
