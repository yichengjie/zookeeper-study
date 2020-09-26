package com.yicj.item.service.impl;

import com.yicj.item.service.ItemsService;
import com.yicj.mapper.ItemsMapper;
import com.yicj.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public Items getItem(String itemId) {
		return itemsMapper.selectByPrimaryKey(itemId);
	}
	
	@Override
	public int getItemCounts(String itemId) {
		Items item = itemsMapper.selectByPrimaryKey(itemId);
		return item.getCounts();
	}

	@Override
	public void displayReduceCounts(String itemId, int buyCounts) {
		//int a  = 1 / 0;
		Items reduceItem = new Items();
		reduceItem.setId(itemId);
		reduceItem.setBuyCounts(buyCounts);
		itemsMapper.reduceCounts(reduceItem);
	}

}

