package com.breed.govern.service.impl;

import com.breed.govern.dto.vo.OperationLabelListVo;
import com.breed.govern.dto.vo.OperationListVo;
import com.breed.govern.dto.vo.SelectOperationLabelListVo;
import com.breed.govern.entity.BOperation;
import com.breed.govern.entity.BOperationLabel;
import com.breed.govern.mapper.BOperationLabelMapper;
import com.breed.govern.service.IBOperationLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 普通操作标签表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
@Service
public class BOperationLabelServiceImpl extends ServiceImpl<BOperationLabelMapper, BOperationLabel> implements IBOperationLabelService {

    @Override
    public int createOperationLabel(BOperationLabel data) {
        return baseMapper.insert(data);
    }

    @Override
    public int updateOperationLabel(BOperationLabel data) {
        return baseMapper.updateById(data);
    }

    @Override
    public List<OperationLabelListVo> getOperationLabelList() {
        return baseMapper.getOperationLabelList();
    }

    @Override
    public BOperationLabel getOperationLabelById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteOperationLabel(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<SelectOperationLabelListVo> selectOperationLabelListVo() {
        return baseMapper.SelectOperationLabelListVo();
    }

    @Override
    public Long getOlIdByContent() {
        return baseMapper.getOlIdByContent();
    }
}
