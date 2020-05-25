package com.proxy.dp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.proxy.IExpress;

/**
 * jdk动态代理 代理类需要实现jdk的InvocationHandler接口
 * 通过java反射机制加载
 * @author Administrator
 *
 */
public class ProxyDynamic implements InvocationHandler{

	private IExpress express ;
	public ProxyDynamic(IExpress express) {
		this.express = express;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("jdk动态代理 动态处理器实现类");
		Object o = method.invoke(express, args);
		System.out.println("通过java反射机制调用对象的方法");
		return o;
	}

}
