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
 * �ͻ��˲�����
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		//��̬�������
		/*IExpress express = new RealExpressRecive();
		IExpress proxyStaticRecive = new ProxyStatic(express);
		proxyStaticRecive.reciveExpress("��ͨ���");*/
		
		//jdk��̬����
	/*	final IExpress expressObj = new RealExpressRecive();
		*//**
		 * ClassLoader loader:ָ����ǰĿ�����ʹ�õ��������,��ȡ�������ķ����ǹ̶���
         * Class<?>[] interfaces:ָ��Ŀ�����ʵ�ֵĽӿڵ�����,ʹ�÷��ͷ�ʽȷ������
         * InvocationHandler:ָ����̬��������ִ��Ŀ�����ķ���ʱ,�ᴥ���¼��������ķ���
		 *//*
		IExpress proxyJdk = (IExpress)Proxy.newProxyInstance(expressObj.getClass().getClassLoader(), expressObj.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("����jdk��̬����");
				String rtn = (String)method.invoke(expressObj, args);
				System.out.println("JDK��̬����   "+rtn+"  ǩ ��ʱ��:"+System.currentTimeMillis());
				return rtn;
			}
		});
		proxyJdk.reciveExpress("Բͨ���");
		System.out.println("-------------------------------");
		IExpress proxyHandler = (IExpress) Proxy.newProxyInstance(expressObj.getClass().getClassLoader(), expressObj.getClass().getInterfaces(),
				new ProxyDynamic(expressObj));
		proxyHandler.reciveExpress("˳����");*/
		
		//cglib����
		IExpress expressCglib = new RealExpressRecive();
		IExpress cglibProxy = (IExpress) new ProxyDynamicCglib(expressCglib).getProxyObj();
		String rtn = cglibProxy.reciveExpress("Բͨ���");
		System.out.println(rtn+"  ǩ��ʱ��:"+System.currentTimeMillis());
	}
}
