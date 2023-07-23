package com.breed.govern.mapper;

import com.breed.govern.dto.vo.FermentListVo;
import com.breed.govern.dto.vo.SelectFermentListVo;
import com.breed.govern.entity.BFeedFerment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 发酵表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
public interface BFeedFermentMapper extends BaseMapper<BFeedFerment> {
    List<FermentListVo> getFermentList(@Param(value = "fermentStatus")  int fermentStatus);
    List<SelectFermentListVo> getSelectFermentList();
}
