package com.wang.material.api.common;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.material.material.enums.MaterialErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title: BaseController
 * @Description: 基础控制层获取基础请求信息
 * @date 2020年2月13日 下午3:52:19
 * @version V1.0
 *
 */
@Slf4j
public abstract class BaseOperationPlatformController {

    protected static final Logger logger = LoggerFactory.getLogger(BaseOperationPlatformController.class);

    /**
     * 获取request对象
     *
     * @return
     */
    public HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    /**
     * 默认序列化输出规则
     */
    protected SerializerFeature[] DEFAULT_FEATURES = new SerializerFeature[] { SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullNumberAsZero, SerializerFeature.NotWriteDefaultValue,
            SerializerFeature.WriteMapNullValue };

    /**
     * 获取登录用户
     *
     * @return RequestHeader
     */
    protected RequestHeader getCurrentLoginUser() {

        // 获取操作人
        String operator = getRequest().getHeader("operator");
        Assert.notNull(operator, MaterialErrorEnum.OPERATOR_NOT_EMPTY.getErrorMessage());

        //信息存入请求头
        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setOperator(operator.trim());
        return requestHeader;
    }

    /**
     * 获取请求头操作者信息
     * @return RequestHeader
     */
    public String getOperator() {
        // 获取操作人
        String operator = getRequest().getHeader("operator");
        //操作人非空校验
        if (StringUtils.isEmpty(operator)) {
            throw new RuntimeException(MaterialErrorEnum.OPERATOR_NOT_EMPTY.getErrorMessage());
        }
        return operator.trim();
    }
}
