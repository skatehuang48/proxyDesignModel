package com.proxy.dp;

import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib实现动态代理
 * 依赖cglib.jar和asm.jar
 * 原理：动态生成一个要代理类的子类，子类重写要代理的类的所有不是final的方法。
 * 在子类中采用方法拦截的技术拦截所有父类方法的调用（实现MethodInterceptor接口），顺势织入横切逻辑。它比使用java反射的JDK动态代理要快。
 *
 */
public class ProxyDynamicCglib implements MethodInterceptor{

	private Object obj;
	public ProxyDynamicCglib(Object _obj){
		this.obj = _obj;
	}
	
	/**
	 * 生成代理对象
	 * @return
	 */
	public Object getProxyObj(){
		//Enhancer类是cglib中的一个字节码增强器，用来创建动态代理类
		Enhancer enhancer = new Enhancer();
		//为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
		enhancer.setSuperclass(this.obj.getClass());
		//设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
		enhancer.setCallback(this);//通过实现MethodInterceptor实现方法回调
		 // 创建动态代理类对象并返回
		return enhancer.create();
	}
	
	
	/**
	 * obj：cglib动态生成的代理实例
		method：为上文中实体类所调用的被代理的方法调用
		args：为method参数数值列表
		methodProxy:为生成代理类对方法的代理引用
		返回：从代理实例方法调用返回的值
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("cglib 动态代理");
		Object o = proxy.invokeSuper(obj, args);//调用业务类（父类中）的方法invokeSuper
		return o;
	}

}
