package com.breed.govern.service.impl;

import com.breed.govern.dto.data.ExcOperationBatchData;
import com.breed.govern.dto.vo.ExcOperationListVo;
import com.breed.govern.dto.vo.GetExcOperationInfo;
import com.breed.govern.entity.BExcOperation;
import com.breed.govern.entity.BOperation;
import com.breed.govern.mapper.BExcOperationMapper;
import com.breed.govern.service.IBExcOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 异常操作表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Service
public class BExcOperationServiceImpl extends ServiceImpl<BExcOperationMapper, BExcOperation> implements IBExcOperationService {

    @Override
    public int createExcOperation(BExcOperation data) {
        data.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(data);
    }

    @Override
    public int updateExcOperation(BExcOperation data) {
        return baseMapper.updateById(data);
    }

    @Override
    public List<ExcOperationListVo> getExcOperationList(long eid) {
        List<ExcOperationListVo> excOperationList = baseMapper.getExcOperationList(eid);
        return excOperationList;
    }

    @Override
    public BExcOperation getExcOperationById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<GetExcOperationInfo> getExcOperationByEid(Integer id) {
        return baseMapper.getExcOperationByEid(id);
    }

    @Override
    public Integer deleteExcOperation(long id) {
        return baseMapper.deleteById(id);
    }

    public String getOperationByeId(long eId){
        return baseMapper.getOperationByeId(eId);
    }

    @Override
    public void batchExcOperation(ExcOperationBatchData batch) {
        baseMapper.batchExcOperation(batch);
    }
}
