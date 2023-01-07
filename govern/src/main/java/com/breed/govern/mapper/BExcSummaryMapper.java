package com.breed.govern.mapper;

import com.breed.govern.entity.BExcSummary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 问题解决汇总表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface BExcSummaryMapper extends BaseMapper<BExcSummary> {

    long getSummaryByLabel(@Param(value = "data")String data);
}
