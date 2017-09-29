package cn.itcast.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Myadvice {
   
	//前置通知
	public void before(){
		System.out.println("前置通知！");
		
	}
	
//	环绕通知
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("我是环绕通知，前半部分");
		Object obj =pjp.proceed();//执行目标代码
		System.out.println("我是环绕通知，后半部分！");
		return obj;
	}
	//后置通知
	public void afterRrturning (){
		System.out.println("我是后置通知！如果目标代码出现异常，不会执行");
		
	}
//	后置通知
	public void after (){
		System.out.println("我是后置通知！如果目标代码出现异常仍然会执行");
	}
	//异常拦截通知
	public void afterThowing(){
		System.out.println("我是异常拦截通知！如果目标代码出现异常，就会执行");
	}
}
