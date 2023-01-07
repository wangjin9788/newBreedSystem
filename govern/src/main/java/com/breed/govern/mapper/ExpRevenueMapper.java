package com.breed.govern.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.breed.govern.dto.param.RevenueDataParam;
import com.breed.govern.entity.ExpRevenue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
public interface ExpRevenueMapper extends BaseMapper<ExpRevenue> {

 List<RevenueDataParam> getRevenueList(Page<RevenueDataParam> page, @Param("time") String time);
}
