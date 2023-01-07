package com.breed.govern.mapper;

import com.breed.govern.dto.vo.SelectAdNatureListVo;
import com.breed.govern.entity.AdNature;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 病害性质 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
public interface AdNatureMapper extends BaseMapper<AdNature> {
    List<SelectAdNatureListVo> selectAdNatureList();
}
