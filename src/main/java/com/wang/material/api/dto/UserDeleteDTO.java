package com.wang.material.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: TODO
 * @author
 * @date 2022/1/20 17:03
 * @version 1.0
 */
@Data
@ApiModel("用户删除")
public class UserDeleteDTO {

    @ApiModelProperty(value = "用户Id", name = "id", dataType = "List", required = true)
    private List<Long> id;


    @ApiModelProperty(value = "修改人", name = "updateBy", dataType = "String", required = true)
    @NotNull
    private String updateBy;


}
