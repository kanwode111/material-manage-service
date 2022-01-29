package com.wang.material.material.enums;


import com.wang.material.material.exception.IError;

/**
 * 评论错误枚举类
 * @author tianzheng
 * @Date 2021/09/24
 */
public enum MaterialErrorEnum implements IError {
	USERNAME_ALREADY_EXIST        ("7000001", "用户名已经存在"),
	OPERATOR_NOT_EMPTY("7000001", "操作人不能为空")
	;
	private String errorCode;

	private String errorMessage;

	MaterialErrorEnum(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


	@Override
	public String getNamespace() {
		return "SURVEYERROR-";
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}
}
