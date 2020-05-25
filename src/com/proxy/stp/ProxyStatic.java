package com.proxy.stp;

import com.proxy.IExpress;

/**
 * ��̬����
 * ���������Ҫ��Ŀ�����һ��ʵ�ֳ��������ɫ
 * ��Ҫ�и�����������Ŀ�����
 * @author Administrator
 *
 */
public class ProxyStatic implements IExpress{
	private IExpress expressRecive;
	
	/**
	 * ����������Ŀ�����
	 * @param express
	 */
	public ProxyStatic(IExpress express) {
		this.expressRecive = express;
	}

	/**
	 * ���������Ϊ
	 * �����տ�ݲ����տ�ݺ��ӡǩ�տ��ʱ��
	 */
	@Override
	public String reciveExpress(String expressType) {
		String rtnValue = this.expressRecive.reciveExpress(expressType);
		long time = System.currentTimeMillis();
		System.out.println(rtnValue+"  ǩ��ʱ�䣺"+time);
		return rtnValue;
	}

}
