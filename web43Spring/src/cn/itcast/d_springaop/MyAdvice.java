package cn.itcast.d_springaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	
	//书写通知方法
//		|-前置通知  通知的代码希望在目标代码执行之前调用
//		|-环绕通知  在目标代码执行之前和之后都调用
//		|-后置通知  通知的代码在目标代码执行之后调用,如果目标代码出现异常,不执行通知代码
//		|-后置通知  通知的代码在目标代码执行之后调用,如果目标代码出现异常,仍然执行通知代码
//		|-异常拦截通知  当目标代码出现异常才会执行.
	
	//前置通知
	public void before(){
		System.out.println("我是前置通知!");
	}
	//环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("我是环绕通知,前半部分!");
		Object obj = pjp.proceed();//执行目标方法
	
		System.out.println("我是环绕通知,后半部分!");
		return obj;
	}
	//后置通知
	public void afterReturning(){
			System.out.println("我是后置通知!如果目标代码出现异常,不会执行!");
	}
	//后置通知
	public void after(){
			System.out.println("我是后置通知!如果目标代码出现异常,仍然会执行!");
	}
	//异常拦截通知
	public void afterThrowing(){
		System.out.println("我是异常拦截通知!如果目标代码出现异常,就会执行!");
		
	}
	
}
