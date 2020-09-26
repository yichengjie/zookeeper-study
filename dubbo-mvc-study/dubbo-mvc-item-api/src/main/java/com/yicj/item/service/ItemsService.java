package com.yicj.item.service;

import com.yicj.item.pojo.Items;

public interface ItemsService {

	public Items getItem(String itemId);
	
	/**
	 * @Description: 查询商品库存
	 */
	public int getItemCounts(String itemId);
	
	/**
	 * @Description: 购买商品成功后减少库存
	 */
	public void displayReduceCounts(String itemId, int buyCounts);

}

