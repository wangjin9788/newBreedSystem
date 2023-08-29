package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breed.govern.dto.vo.BreedListVo;
import com.breed.govern.entity.BBreed;
import com.breed.govern.mapper.BBreedMapper;
import com.breed.govern.mapper.BBreedFormulaMapper;
import com.breed.govern.service.IBBreedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
@Service
public class BBreedServiceImpl extends ServiceImpl<BBreedMapper, BBreed> implements IBBreedService {

    @Resource
    private BBreedFormulaMapper mapper;

    @Override
    public int createBreed(BBreed breed) {
        breed.setCreateTime(LocalDateTime.now());
        return baseMapper.insert(breed);
    }

    @Override
    public int updateBreed(BBreed breed) {
        return baseMapper.updateById(breed);
    }

    @Override
    public List<BreedListVo> getBreedList(Integer status, Integer pageSize, Integer pageNum, Integer type) {
        Page<BreedListVo> page = new Page<>(pageNum, pageSize);
        return baseMapper.getBreedInfoList(page, status, type);
    }

    @Override
    public BBreed getBreedById(long id) {
        return baseMapper.selectById(id);
    }
    @Override
    public Integer deleteBreed(long id) {
        return  baseMapper.deleteById(id);
    }

    @Override
    public List<Long> getBreedAllId() {
        return baseMapper.getBreedAllId();
    }
}
