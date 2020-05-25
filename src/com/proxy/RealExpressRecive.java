package com.proxy;
/**
 * 真实快递接收对象
 * @author Administrator
 *
 */
public class RealExpressRecive implements IExpress{

	@Override
	public String reciveExpress(String expressType) {
		System.out.println("接受来自【"+expressType+"】的快递");
		return "【"+expressType+"】已签收";
	}

}
