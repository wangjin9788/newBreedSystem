package com.breed.govern.service.impl;

import com.breed.govern.entity.BExcSummary;
import com.breed.govern.mapper.BExcSummaryMapper;
import com.breed.govern.service.IBExcSummaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 问题解决汇总表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Service
public class BExcSummaryServiceImpl extends ServiceImpl<BExcSummaryMapper, BExcSummary> implements IBExcSummaryService {

    @Override
    public long getSummaryByLabel(String data) {
        return baseMapper.getSummaryByLabel(data);
    }

    @Override
    public List<BExcSummary> getSummaryList() {
        return baseMapper.selectList(null);
    }
}
