package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breed.govern.dto.vo.SelectExcLabelList;
import com.breed.govern.entity.BExcLabel;
import com.breed.govern.mapper.BExcLabelMapper;
import com.breed.govern.service.IBExcLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 检测病害标签表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Service
public class BExcLabelServiceImpl extends ServiceImpl<BExcLabelMapper, BExcLabel> implements IBExcLabelService {

    @Override
    public int createExcLabel(BExcLabel data) {
        return baseMapper.insert(data);
    }

    @Override
    public int updateExcLabel(BExcLabel data) {
        return baseMapper.updateById(data);
    }

    @Override
    public Integer deleteExcLabel(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public BExcLabel getExcLabelById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<BExcLabel> getExcLabelList() {
        QueryWrapper<BExcLabel> queryWrapper =new QueryWrapper<>();
        queryWrapper.orderByDesc("like_count");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<SelectExcLabelList> SelectExcLabelList() {
        List<BExcLabel> data = baseMapper.selectList(null);
        List<SelectExcLabelList> list = new ArrayList<>();
        for (BExcLabel d :
                data) {
            SelectExcLabelList vo = new SelectExcLabelList();
            vo.setSymptom(d.getLId());
            vo.setExcLabel(d.getLabelName());
            list.add(vo);
        }
        return list;
    }
}
