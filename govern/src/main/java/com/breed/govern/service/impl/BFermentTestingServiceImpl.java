package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breed.govern.entity.BFeedFerment;
import com.breed.govern.entity.BFeedInfo;
import com.breed.govern.entity.BFermentTesting;
import com.breed.govern.mapper.BFeedFermentMapper;
import com.breed.govern.mapper.BFeedInfoMapper;
import com.breed.govern.mapper.BFermentTestingMapper;
import com.breed.govern.service.IBFermentTestingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 发酵结束表
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-11
 */
@Service
public class BFermentTestingServiceImpl extends ServiceImpl<BFermentTestingMapper, BFermentTesting> implements IBFermentTestingService {

    @Autowired
    private BFeedFermentMapper feedFermentMapper;

    @Autowired
    private BFeedInfoMapper feedInfoMapper;

    @Override
    public int createFermentTesting(BFermentTesting data) {
        BFeedFerment feedFermentInfo = feedFermentMapper.selectById(data.getFfId());
        if (feedFermentInfo == null) {
            throw new RuntimeException("没有对应的数据");
        }
        BFeedInfo info = new BFeedInfo();
        info.setFfId(data.getFfId());
        info.setMark(feedFermentInfo.getMark());
        info.setCreateTime(LocalDateTime.now());
        feedInfoMapper.insert(info);
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
        QueryWrapper<BFermentTesting> queryWrapper = new QueryWrapper<BFermentTesting>();
        queryWrapper.eq("ff_id", ffid);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public BFermentTesting getFermentTestingById(Integer id) {
        return baseMapper.selectById(id);
    }
}
