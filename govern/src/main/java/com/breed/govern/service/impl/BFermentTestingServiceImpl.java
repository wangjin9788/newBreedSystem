package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breed.govern.entity.BFermentTesting;
import com.breed.govern.mapper.BFermentTestingMapper;
import com.breed.govern.service.IBFermentTestingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 发酵结束表
 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-11
 */
@Service
public class BFermentTestingServiceImpl extends ServiceImpl<BFermentTestingMapper, BFermentTesting> implements IBFermentTestingService {

    @Override
    public int createFermentTesting(BFermentTesting data) {
        return baseMapper.insert(data);
    }

    @Override
    public int updateFermentTesting(BFermentTesting data) {
        return baseMapper.updateById(data);
    }

    @Override
    public int deleteFermentTesting(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<BFermentTesting> getFermentTestingList(Long ffid) {
        QueryWrapper<BFermentTesting> queryWrapper =new QueryWrapper<BFermentTesting>();
        queryWrapper.eq("ff_id",ffid);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public BFermentTesting getFermentTestingById(Integer id) {
        return baseMapper.selectById(id);
    }
}
