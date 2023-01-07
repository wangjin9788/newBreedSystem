package com.breed.govern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.dto.param.RevenueDataParam;
import com.breed.govern.entity.ExpPayRevenueCategory;
import com.breed.govern.entity.ExpRevenue;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
public interface IExpRevenueService extends IService<ExpRevenue> {

    int create( ExpRevenue expRevenue);

    List<RevenueDataParam> list(String keyword, int pageSize, int pageNum);

    List<ExpPayRevenueCategory> getCategory();

   int update( ExpRevenue  exp);

    ExpRevenue getRevenue( Long id);

    int delete( Long id);

}
