package com.yicj.web.controller;

import com.yicj.common.utils.CommonJSONResult;
import com.yicj.web.service.BuyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description: 订购商品controller
 */
@Controller
public class BuyController {
	@Autowired
	private BuyService buyService;
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/buy")
	@ResponseBody
	public CommonJSONResult doGetlogin(String itemId) {
		if (StringUtils.isNotBlank(itemId)) {
			buyService.doBuyItem(itemId);
		} else {
			return CommonJSONResult.errorMsg("商品id不能为空");
		}
		return CommonJSONResult.ok();
	}
	
}
