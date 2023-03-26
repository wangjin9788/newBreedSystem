package com.breed.govern.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.breed.govern.dto.vo.BreedListVo;
import com.breed.govern.entity.BFermentDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2023-03-25
 */
public interface BFermentDetailMapper extends BaseMapper<BFermentDetail> {
    List<BFermentDetail>  getFermentDetailList(@Param(value = "id")long id, Page<BFermentDetail> page);
}
