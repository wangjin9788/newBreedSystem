package com.breed.govern.mapper;

import com.breed.govern.dto.vo.BreedFormulaListVo;
import com.breed.govern.entity.BBreedFormula;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 饲料配置表
 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-22
 */
public interface BBreedFormulaMapper extends BaseMapper<BBreedFormula> {

    List<BreedFormulaListVo> getFormulaList(@Param(value = "type") Integer type);
}
