package com.wang.material.utils;

import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * 断言工具类
 * 2020年1月9日
 * @author LPC
 *
 */
public class AssertUtils extends Assert {

    /**
     * 检查操作人是否为空
     * @param operator
     */
    public static void checkOperator(String operator){
        if(ObjectUtils.isEmpty(operator)){
            // throw new DataManagementException(ElectronicManualErrorEnum.CREATED_BY_NOT_ALLOWED_EMPTY);
        }
    }

}
