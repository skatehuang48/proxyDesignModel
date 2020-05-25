package com.proxy;
/**
 * 收快递案例
 * 抽象主题角色：收快递类
 * 真实主题角色：实现收快递的接口
 * 代理角色：快递代收点
 * @author Administrator
 *
 */
public interface IExpress {
	public String reciveExpress(String expressType);
}
