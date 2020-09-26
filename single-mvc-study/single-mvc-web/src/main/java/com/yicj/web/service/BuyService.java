package com.yicj.web.service;

public interface BuyService {
	/**
	 * @Description: 购买商品
	 */
	void doBuyItem(String itemId);
	boolean displayBuy(String itemId);
}
