package com.proxy;
/**
 * ��ʵ��ݽ��ն���
 * @author Administrator
 *
 */
public class RealExpressRecive implements IExpress{

	@Override
	public String reciveExpress(String expressType) {
		System.out.println("�������ԡ�"+expressType+"���Ŀ��");
		return "��"+expressType+"����ǩ��";
	}

}
