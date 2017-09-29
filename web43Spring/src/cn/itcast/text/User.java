package cn.itcast.text;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("user")
//@Controller("user")  Web
//@Service("user")
//@Repository("user")   Dao
@Scope("singleton")
public class User {
	@Value("Tom")
	//相当于<property name="name" value="Tom">
     private String name;
	
	//<property name="age" value="18">
     private Integer age;
	//@Autowired自动封装，    但是有相同的Bean时就只会封装到一个Bean
	@Resource(name="car")//直接指定到Bean中
     private Car car;
     
     
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public User() {
		super();
	System.out.println("Use对象被创建了。。。。");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	@Value("18")
	public void setAge(Integer age) {
		this.age = age;
	}
	@PostConstruct
	//bean元素init——method
     public void init(){
    	 System.out.println("初始化方法被调用了！");
     }
	@PreDestroy
	//bean元素destory——method
	public void destroy(){
		System.out.println("销毁方法被调用了。。。");
	}
}
