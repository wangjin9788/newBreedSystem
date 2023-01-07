package com.breed.govern.service.impl;

import com.breed.govern.dto.vo.RateItemVo;
import com.breed.govern.entity.BNutritionalRate;
import com.breed.govern.mapper.BNutritionalRateMapper;
import com.breed.govern.service.IBNutritionalRateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 营养比例表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-17
 */
@Service
public class BNutritionalRateServiceImpl extends ServiceImpl<BNutritionalRateMapper, BNutritionalRate> implements IBNutritionalRateService {

    @Override
    public List<RateItemVo> getRateList() {
        List<BNutritionalRate> data = baseMapper.selectList(null);
        List<RateItemVo> fatherList=new ArrayList<>();
        for (BNutritionalRate vo: data) {
            RateItemVo father=new RateItemVo();
            father.setValue(vo.getNutName());
            father.setLabel(vo.getNutName());
            List<RateItemVo> sonList=new ArrayList<>();
            RateItemVo son=new RateItemVo();
            son.setValue(String.valueOf(vo.getRate()));
            son.setLabel(String.valueOf(vo.getRate()));
            sonList.add(son);
            father.setChildren(sonList);
            fatherList.add(father);
        }
        return fatherList;
    }

    @Override
    public int createRate(BNutritionalRate rate) {
        return baseMapper.insert(rate);
    }
}
