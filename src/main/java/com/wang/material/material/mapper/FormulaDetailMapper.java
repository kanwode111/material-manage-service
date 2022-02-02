package com.wang.material.material.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.material.material.entity.FormulaDetailEntity;
import com.wang.material.material.entity.FormulaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FormulaDetailMapper extends BaseMapper<FormulaDetailEntity> {

    Integer insertBatch(@Param("details") List<FormulaDetailEntity> details);

}
