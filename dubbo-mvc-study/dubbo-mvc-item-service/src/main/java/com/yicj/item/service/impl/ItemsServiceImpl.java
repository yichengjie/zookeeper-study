package com.yicj.item.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yicj.item.mapper.ItemsMapper;
import com.yicj.item.pojo.Items;
import com.yicj.item.service.ItemsService;

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
		
		Items reduceItem = new Items();
		reduceItem.setId(itemId);
		reduceItem.setBuyCounts(buyCounts);
		itemsMapper.reduceCounts(reduceItem);
	}

}

