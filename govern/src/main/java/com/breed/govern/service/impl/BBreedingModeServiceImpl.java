package com.breed.govern.service.impl;

import com.breed.govern.dto.vo.BreedModelListVo;
import com.breed.govern.dto.vo.SelectBreedModelListVo;
import com.breed.govern.entity.BBreedingMode;
import com.breed.govern.mapper.BBreedingModeMapper;
import com.breed.govern.service.IBBreedingModeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class BBreedingModeServiceImpl extends ServiceImpl<BBreedingModeMapper, BBreedingMode> implements IBBreedingModeService {

    @Override
    public int createBreedingMode(BBreedingMode model) {
        return baseMapper.insert(model);
    }

    @Override
    public int updateBreedingMode(BBreedingMode model) {
        return baseMapper.updateById(model);
    }

    @Override
    public Integer deleteBreedingMode(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public BBreedingMode getBreedingModeById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<BreedModelListVo> getModelList() {
        return baseMapper.getBreedModelList();
    }

    @Override
    public List<SelectBreedModelListVo> selectBreedModelListVoList(){
        return baseMapper.selectBreedModelList();
    }
}
