package com.proxy.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.proxy.IExpress;
import com.proxy.RealExpressRecive;
import com.proxy.dp.ProxyDynamic;
import com.proxy.dp.ProxyDynamicCglib;
import com.proxy.stp.ProxyStatic;

/**
 * 客户端测试类
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		//静态代理测试
		/*IExpress express = new RealExpressRecive();
		IExpress proxyStaticRecive = new ProxyStatic(express);
		proxyStaticRecive.reciveExpress("中通快递");*/
		
		//jdk动态代理
	/*	final IExpress expressObj = new RealExpressRecive();
		*//**
		 * ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
         * Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
         * InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
		 *//*
		IExpress proxyJdk = (IExpress)Proxy.newProxyInstance(expressObj.getClass().getClassLoader(), expressObj.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("我是jdk动态代理");
				String rtn = (String)method.invoke(expressObj, args);
				System.out.println("JDK动态代理：   "+rtn+"  签 收时间:"+System.currentTimeMillis());
				return rtn;
			}
		});
		proxyJdk.reciveExpress("圆通快递");
		System.out.println("-------------------------------");
		IExpress proxyHandler = (IExpress) Proxy.newProxyInstance(expressObj.getClass().getClassLoader(), expressObj.getClass().getInterfaces(),
				new ProxyDynamic(expressObj));
		proxyHandler.reciveExpress("顺丰快递");*/
		
		//cglib代理
		IExpress expressCglib = new RealExpressRecive();
		IExpress cglibProxy = (IExpress) new ProxyDynamicCglib(expressCglib).getProxyObj();
		String rtn = cglibProxy.reciveExpress("圆通快递");
		System.out.println(rtn+"  签收时间:"+System.currentTimeMillis());
	}
}
