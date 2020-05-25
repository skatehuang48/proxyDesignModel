package com.proxy.dp;

import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglibʵ�ֶ�̬����
 * ����cglib.jar��asm.jar
 * ԭ����̬����һ��Ҫ����������࣬������дҪ�����������в���final�ķ�����
 * �������в��÷������صļ����������и��෽���ĵ��ã�ʵ��MethodInterceptor�ӿڣ���˳��֯������߼�������ʹ��java�����JDK��̬����Ҫ�졣
 *
 */
public class ProxyDynamicCglib implements MethodInterceptor{

	private Object obj;
	public ProxyDynamicCglib(Object _obj){
		this.obj = _obj;
	}
	
	/**
	 * ���ɴ������
	 * @return
	 */
	public Object getProxyObj(){
		//Enhancer����cglib�е�һ���ֽ�����ǿ��������������̬������
		Enhancer enhancer = new Enhancer();
		//Ϊ��ǿ��ָ��Ҫ�����ҵ���ࣨ����Ϊ�������ɵĴ�����ָ�����ࣩ
		enhancer.setSuperclass(this.obj.getClass());
		//���ûص������ڴ����������з����ĵ��ã��������CallBack����Callback����Ҫʵ��intercept()����������
		enhancer.setCallback(this);//ͨ��ʵ��MethodInterceptorʵ�ַ����ص�
		 // ������̬��������󲢷���
		return enhancer.create();
	}
	
	
	/**
	 * obj��cglib��̬���ɵĴ���ʵ��
		method��Ϊ������ʵ���������õı�����ķ�������
		args��Ϊmethod������ֵ�б�
		methodProxy:Ϊ���ɴ�����Է����Ĵ�������
		���أ��Ӵ���ʵ���������÷��ص�ֵ
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("cglib ��̬����");
		Object o = proxy.invokeSuper(obj, args);//����ҵ���ࣨ�����У��ķ���invokeSuper
		return o;
	}

}
