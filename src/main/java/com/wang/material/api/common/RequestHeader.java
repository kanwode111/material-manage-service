package com.wang.material.api.common;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 请求头信息
 * @author LPC
 *
 */
@ToString
@Data
public class RequestHeader {
	
	/**
	 * 操作人
	 */
	private String operator;
	
	/**
	 * 企业品牌ID
	 */
	private List<String> brandId;
	
	/**
	 * 企业ID
	 */
	private List<String> enterpriseId;
	
	
}
