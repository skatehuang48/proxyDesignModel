package com.proxy.dp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.proxy.IExpress;

/**
 * jdk��̬���� ��������Ҫʵ��jdk��InvocationHandler�ӿ�
 * ͨ��java������Ƽ���
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
		System.out.println("jdk��̬���� ��̬������ʵ����");
		Object o = method.invoke(express, args);
		System.out.println("ͨ��java������Ƶ��ö���ķ���");
		return o;
	}

}
