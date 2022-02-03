package com.wang.material.material.enums;


/**
 * 评论错误枚举类
 * @author tianzheng
 * @Date 2021/09/24
 */
public enum MaterialErrorEnum  {
	USERNAME_ALREADY_EXIST        ("7000001", "用户名已经存在"),
	OPERATOR_NOT_EMPTY	("7000002", "操作人不能为空"),
	CANNOT_UPDATE_PASSWORD	("7000003", "非管理员用户只能修改自己密码"),
	CANNOT_DELETE_USER	("7000004", "非管理员用户不能删除用户"),
	CANNOT_DELETE_MATERIAL	("7000005", "不能删除原材料，原材料在配方中有使用"),
	CANNOT_DELETE_MATERIAL_TYPE	("7000006", "不能删除原材料类型，原材料类型下面存在原材料"),
	FORMULA_NAME_CODE_EXIST	("7000007", "配方名称已经存在"),
	CANNOT_DELETE_FORMULA_PART	("7000008", "不能删除配方步骤，配方步骤下面含有配方"),
	FORMULA_PART_NOT_EXIST	("7000009", "配方步骤不存在"),
	;
	private String errorCode;

	private String errorMessage;

	MaterialErrorEnum(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


	public String getNamespace() {
		return "MATERIAL-";
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
