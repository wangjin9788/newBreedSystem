package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.breed.govern.dto.param.FermentEndTestingParam;
import com.breed.govern.dto.vo.FermentListVo;
import com.breed.govern.dto.vo.SelectFermentListVo;
import com.breed.govern.entity.BFeedFerment;
import com.breed.govern.entity.BFermentTesting;
import com.breed.govern.mapper.BFeedFermentMapper;
import com.breed.govern.service.IBFeedFermentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public List<FermentListVo> getFermentList(String selectDay) {
        String year = "";
        String month = "";
        if (selectDay != null && selectDay != "") {
            String[] split = selectDay.split("-");
            year = split[0];
            month = split[1];
        }
        return baseMapper.getFermentList(year, month);
    }

    @Override
    public BFeedFerment getFeedFermentById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<SelectFermentListVo> getSelectFermentList() {
        return baseMapper.getSelectFermentList();
    }
}
