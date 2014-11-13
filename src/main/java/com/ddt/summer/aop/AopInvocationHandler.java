package com.ddt.summer.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AopInvocationHandler implements InvocationHandler{
	
	private Object target;
	
	public AopInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object rev = method.invoke(target, args);
		if(method.getName().equals("doSomething2")){
			System.out.println("记录日志");
		}
		return rev;
	}

}
