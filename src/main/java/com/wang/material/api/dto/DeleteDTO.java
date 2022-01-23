package com.wang.material.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 删除父类
 * @author
 * @date 2022/1/17 10:59
 * @version 1.0
 */
@Data
public class DeleteDTO {
    @ApiModelProperty(value = "Id", name = "id", dataType = "Long", required = true)
    private Long id;


    @ApiModelProperty(value = "修改人", name = "updateBy", dataType = "String", required = true)
    @NotNull
    private String updateBy;
}
