package com.breed.govern.service.impl;

import com.breed.govern.dto.vo.SelectAdNatureListVo;
import com.breed.govern.entity.AdNature;
import com.breed.govern.entity.BBreedingMode;
import com.breed.govern.mapper.AdNatureMapper;
import com.breed.govern.service.IAdNatureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 病害性质 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
@Service
public class AdNatureServiceImpl extends ServiceImpl<AdNatureMapper, AdNature> implements IAdNatureService {

    @Override
    public int createAdNature(AdNature nature) {
        return baseMapper.insert(nature);
    }

    @Override
    public int updateAdNature(AdNature nature) {
        return baseMapper.updateById(nature);
    }

    @Override
    public Integer deleteAdNature(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public AdNature getAdNatureById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<AdNature> getAdNatureList() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<SelectAdNatureListVo> selectAdNatureListVo() {
        return baseMapper.selectAdNatureList();
    }
}
