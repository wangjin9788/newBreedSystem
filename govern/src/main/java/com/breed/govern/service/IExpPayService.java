package com.breed.govern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.dto.param.PayDataParam;
import com.breed.govern.entity.ExpPay;
import com.breed.govern.entity.ExpPayRevenueCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
public interface IExpPayService extends IService<ExpPay> {
    int create(ExpPay expPay );

    List<PayDataParam> list(String keyword, int pageSize, int pageNum);

    List<ExpPayRevenueCategory> getPayRevenueCategory();

    int update( ExpPay expPay);

    ExpPay getPayDetail( Long id);

    int delete( Long id);
}
