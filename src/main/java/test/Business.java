package test;

public class Business implements IBusiness,IBusiness2{

	@Override
	public void doSomething2() {
		System.out.println("执行业务逻辑2");
	}

	@Override
	public boolean doSomething() {
		System.out.println("执行业务逻辑");
		return true;
	}

}
