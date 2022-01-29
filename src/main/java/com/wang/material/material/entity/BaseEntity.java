package com.wang.material.material.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1068386884929087009L;
    @TableId(
            type = IdType.ID_WORKER
    )

    protected Long id;

    @TableField("create_by")
    protected String createBy;
    @TableField("update_by")
    protected String updateBy;
    @TableField("create_date")
    protected Date createDate;
    @TableField("update_date")
    protected Date updateDate;
    @TableField("deleted")
    @TableLogic
    protected Boolean deleted;

    public BaseEntity() {
    }


}
