package com.wang.material.material.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.material.material.entity.FormulaEntity;
import com.wang.material.material.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FormulaMapper extends BaseMapper<FormulaEntity> {

    Integer batchInsert(@Param("formulas") List<FormulaEntity> formulaList);


}
