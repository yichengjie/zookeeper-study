package com.yicj.common.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Description: 用来返回jqGrid的数据格式
 */
@Data
public class JqGridResult {
	private int page;			// 当前页数
	private int total;			// 总页数	
	private long records;		// 总记录数
	private List<?> rows;		// 每行显示的内容
	private Object userdata;	// 用户自定义数据
}
