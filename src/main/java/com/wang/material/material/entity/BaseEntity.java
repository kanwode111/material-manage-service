package com.wang.material.material.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1068386884929087009L;
    @TableId(
            type = IdType.ID_WORKER
    )

    protected Long id;

    @TableField("create_by")
    protected Date createBy;
    @TableField("update_by")
    protected Date updateBy;
    @TableField("create_date")
    protected Date createDate;
    @TableField("update_date")
    protected Date updateDate;
    @TableField("deleted")
    @TableLogic
    protected Boolean deleted;

    public BaseEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
