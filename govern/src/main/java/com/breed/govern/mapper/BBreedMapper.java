package com.breed.govern.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.breed.govern.dto.vo.BreedListVo;
import com.breed.govern.entity.BBreed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
public interface BBreedMapper extends BaseMapper<BBreed> {
    List<BreedListVo> getBreedInfoList(Page<BreedListVo> page, @Param(value = "status") Integer status, @Param(value = "type")Integer type);
    List<Long> getBreedAllId();
}
