package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breed.govern.dto.param.PayDataParam;
import com.breed.govern.entity.ExpPay;
import com.breed.govern.entity.ExpPayRevenueCategory;
import com.breed.govern.mapper.ExpPayMapper;
import com.breed.govern.mapper.ExpPayRevenueCategoryMapper;
import com.breed.govern.service.IExpPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王进
 * @since 2021-04-10
 */
@Service
public class ExpPayServiceImpl extends ServiceImpl<ExpPayMapper, ExpPay> implements IExpPayService {
    @Autowired
    private ExpPayRevenueCategoryMapper categoryMapper;
    @Override
    public int create(ExpPay expPay) {
        expPay.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(expPay);
    }

    @Override
    public List<PayDataParam> list(String keyword, int pageSize, int pageNum) {
        Page<PayDataParam> page= new Page<>(pageNum,pageSize);
        List<PayDataParam> revenueList = baseMapper.getPayList(page, keyword);
        return revenueList;
    }

    @Override
    public List<ExpPayRevenueCategory> getPayRevenueCategory() {
        QueryWrapper<ExpPayRevenueCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",0);
        List<ExpPayRevenueCategory> expPayRevenueCategories = categoryMapper.selectList(queryWrapper);
        return expPayRevenueCategories;
    }

    @Override
    public int update(ExpPay expPay) {
       return baseMapper.updateById(expPay);
    }

    @Override
    public ExpPay getPayDetail(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int delete(Long id) {
        return baseMapper.deleteById(id);
    }
}
