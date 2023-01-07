package com.breed.govern.service;

import com.breed.govern.dto.vo.RateItemVo;
import com.breed.govern.entity.BNutritionalRate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 营养比例表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-17
 */
public interface IBNutritionalRateService extends IService<BNutritionalRate> {
    List<RateItemVo> getRateList();

    int createRate(BNutritionalRate rate);
}
