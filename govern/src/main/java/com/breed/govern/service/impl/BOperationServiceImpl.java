package com.breed.govern.service.impl;

import com.breed.govern.dto.data.OperationBatchData;
import com.breed.govern.dto.vo.OperationListVo;
import com.breed.govern.dto.vo.SelectOperationList;
import com.breed.govern.entity.BOperation;
import com.breed.govern.mapper.BOperationMapper;
import com.breed.govern.service.IBOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 普通操作表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
@Service
public class BOperationServiceImpl extends ServiceImpl<BOperationMapper, BOperation> implements IBOperationService {

    @Override
    public int createOperation(BOperation data) {
        data.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(data);
    }

    @Override
    public int updateOperation(BOperation data) {
        return baseMapper.updateById(data);
    }

    @Override
    public List<OperationListVo> getOperationList(long bid, int type) {
        return baseMapper.getOperationList(bid,type);
    }

    @Override
    public BOperation getOperationById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Integer deleteOperation(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<SelectOperationList> selectOperationList() {
        return baseMapper.selectOperationList();
    }

    @Override
    public void batchOperation(OperationBatchData batch) {
        baseMapper.batchOperation(batch);
    }


}
