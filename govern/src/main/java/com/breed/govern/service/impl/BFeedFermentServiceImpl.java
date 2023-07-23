package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breed.govern.dto.vo.FermentListVo;
import com.breed.govern.dto.vo.SelectFermentListVo;
import com.breed.govern.entity.BFeedFerment;
import com.breed.govern.entity.BFermentTesting;
import com.breed.govern.mapper.BFeedFermentMapper;
import com.breed.govern.service.IBFeedFermentService;
import com.breed.govern.service.IBFermentTestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 发酵表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
@Service
public class BFeedFermentServiceImpl extends ServiceImpl<BFeedFermentMapper, BFeedFerment> implements IBFeedFermentService {

    @Autowired
    private IBFermentTestingService testingService;

    @Override
    public int createFeedFerment(BFeedFerment ferment) {
        return baseMapper.insert(ferment);
    }

    @Override
    public int updateFeedFerment(BFeedFerment ferment) {
        return baseMapper.updateById(ferment);
    }

    @Override
    public Integer deleteFeedFerment(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Integer updateStatus(BFermentTesting data) {
        BFeedFerment ferment = baseMapper.selectById(data.getFfId());
        int isSuccess = 0;
        if (ferment != null && ferment.getStatus() != 1) {
            ferment.setStatus(1);
            isSuccess = baseMapper.updateById(ferment);
            if(isSuccess>0){
                testingService.createFermentTesting(data);
            }
        }
        return isSuccess;
    }

    @Override
    public List<FermentListVo> getFermentList(int fermentStatus) {
        return baseMapper.getFermentList(fermentStatus);
    }

    @Override
    public BFeedFerment getFeedFermentById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<SelectFermentListVo> getSelectFermentList() {
        List<SelectFermentListVo> list = baseMapper.getSelectFermentList();

        return baseMapper.getSelectFermentList();
    }
}
