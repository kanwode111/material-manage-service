package com.wang.material.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @description: 分页查询通用参数
 * @author
 * @date 2021/12/21 16:57
 * @version 1.0
 */
@Data
public class PageQuery {
    @ApiModelProperty(value = "当前页", required = false, dataType = "Integer", example = "1")
    @Max(value = 2147483647)
    @Min(value = 0)
    private Integer pageNumber;

    @ApiModelProperty(value = "每页显示条数", required = false, dataType = "Integer", example = "10")
    @Max(value = 2147483647)
    @Min(value = 1)
    private Integer pageSize ;

    /**
     * @description: 设置分页初始值
     * @param: query
     * @return:
     * @author
     * @date: 2021/12/22 9:39
     */
    public static void setInitSize(PageQuery query) {
        if (query.getPageNumber() == null || query.getPageSize() == null) {
            query.setPageNumber(0);
            query.setPageSize(10);
        }else {
            query.setPageNumber(query.getPageNumber() - 1);
        }
    }
}
