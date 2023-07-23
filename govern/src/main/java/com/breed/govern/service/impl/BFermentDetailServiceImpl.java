package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.breed.govern.entity.BFermentDetail;
import com.breed.govern.mapper.BFermentDetailMapper;
import com.breed.govern.service.IBFermentDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2023-03-25
 */
@Service
public class BFermentDetailServiceImpl extends ServiceImpl<BFermentDetailMapper, BFermentDetail> implements IBFermentDetailService {

    @Override
    public int createFermentDetail(BFermentDetail data) {
        return baseMapper.insert(data);

    }

    @Override
    public int updateFermentDetail(BFermentDetail data) {


        return baseMapper.updateById(data);
    }

    @Override
    public int deleteFermentDetail(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<BFermentDetail> getFermentDetailList(Long ffId,
                                                     Integer pageNum,
                                                     Integer pageSize) {
        Page<BFermentDetail> page = new Page<>(pageNum, pageSize);

        return baseMapper.getFermentDetailList(ffId, page);
    }

    @Override
    public BFermentDetail getFermentDetailById(Long id) {
        return baseMapper.selectById(id);
    }
}
