package com.yicj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yicj.common.utils.CommonJSONResult;
import com.yicj.curator.utils.ZKCurator;
import com.yicj.item.pojo.Items;
import com.yicj.item.service.ItemsService;
import com.yicj.order.pojo.Orders;
import com.yicj.order.service.OrdersService;
import com.yicj.web.service.CulsterService;

@Controller
public class PayController {
	final static Logger log = LoggerFactory.getLogger(PayController.class);
	@Autowired
	private ItemsService itemsService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private CulsterService culsterService;
	@Autowired
	private ZKCurator zkCurator;
	
	@RequestMapping("/test")
	@ResponseBody
	public CommonJSONResult test() {
		return CommonJSONResult.ok("test");
	}
	
	@RequestMapping("/item")
	@ResponseBody
	public CommonJSONResult getItemById(String id) {
		Items item = itemsService.getItem(id);
		return CommonJSONResult.ok(item);
	}
	
	@RequestMapping("/order")
	@ResponseBody
	public CommonJSONResult getOrderById(String id) {
		Orders order = ordersService.getOrder(id);
		return CommonJSONResult.ok(order);
	}
	
	@RequestMapping("/buy")
	@ResponseBody
	public CommonJSONResult buy(String itemId) {
		boolean result = culsterService.displayBuy(itemId);
		return CommonJSONResult.ok(result ? "订单创建成功..." : "订单创建失败...");
	}
	
	/**
	 * @Description: 模拟集群下的数据不一致
	 */
	@RequestMapping("/buy2")
	@ResponseBody
	public CommonJSONResult buy2(String itemId) {
		boolean result = culsterService.displayBuy(itemId);
		return CommonJSONResult.ok(result ? "订单创建成功..." : "订单创建失败...");
	}
	
	/**
	 * @Description: 判断zk是否连接
	 */
	@RequestMapping("/isZKAlive")
	@ResponseBody
	public CommonJSONResult isZKAlive() {
		boolean isAlive = zkCurator.isZKAlive();
		String result = isAlive ? "连接" : "断开";
		return CommonJSONResult.ok(result);
	}
}
