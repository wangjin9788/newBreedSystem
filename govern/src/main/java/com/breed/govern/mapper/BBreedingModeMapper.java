package com.breed.govern.mapper;

import com.breed.govern.dto.vo.BreedModelListVo;
import com.breed.govern.dto.vo.SelectBreedModelListVo;
import com.breed.govern.entity.BBreedingMode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
public interface BBreedingModeMapper extends BaseMapper<BBreedingMode> {
    List<BreedModelListVo> getBreedModelList();
    List<SelectBreedModelListVo>selectBreedModelList();
}
