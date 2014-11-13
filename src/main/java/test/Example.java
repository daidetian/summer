package test;

import java.lang.reflect.Proxy;

import com.ddt.summer.aop.AopInvocationHandler;

import simple.XmlReader;

public class Example {
	
	static void testIOC(){
		Animal a1 = (Animal) XmlReader.getBean("animal");
        a1.say();
	}
	
	static void testAOP(){
		Class<?>[] proxyInterface = new Class[]{IBusiness.class,IBusiness2.class};
		AopInvocationHandler aop = new AopInvocationHandler(new Business());
		ClassLoader classLoader = AopInvocationHandler.class.getClassLoader();
		IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface, aop);
		proxyBusiness.doSomething2();
		((IBusiness) proxyBusiness).doSomething();
	}
	
	public static void main(String[] args){
		testAOP();
    }

}
