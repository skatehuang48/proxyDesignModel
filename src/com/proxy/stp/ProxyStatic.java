package com.proxy.stp;

import com.proxy.IExpress;

/**
 * 静态代理
 * 代理对象需要和目标对象一样实现抽象主题角色
 * 需要有个构造器传入目标对象
 * @author Administrator
 *
 */
public class ProxyStatic implements IExpress{
	private IExpress expressRecive;
	
	/**
	 * 构造器传入目标对象
	 * @param express
	 */
	public ProxyStatic(IExpress express) {
		this.expressRecive = express;
	}

	/**
	 * 具体代理行为
	 * 代理收快递并在收快递后打印签收快递时间
	 */
	@Override
	public String reciveExpress(String expressType) {
		String rtnValue = this.expressRecive.reciveExpress(expressType);
		long time = System.currentTimeMillis();
		System.out.println(rtnValue+"  签收时间："+time);
		return rtnValue;
	}

}
