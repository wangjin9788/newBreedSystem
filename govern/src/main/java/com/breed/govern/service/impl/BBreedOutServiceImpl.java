package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breed.govern.entity.BBreed;
import com.breed.govern.entity.BBreedOut;
import com.breed.govern.mapper.BBreedMapper;
import com.breed.govern.mapper.BBreedOutMapper;
import com.breed.govern.service.IBBreedOutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 产出记录 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-13
 */
@Service
public class BBreedOutServiceImpl extends ServiceImpl<BBreedOutMapper, BBreedOut> implements IBBreedOutService {

    @Resource
   private BBreedMapper breedMapper;

    @Override
    public List<BBreedOut> getBreedOutInfoList(Integer bid) {
        QueryWrapper<BBreedOut> query = new QueryWrapper<>();
        query.eq("b_id", bid);
        return baseMapper.selectList(query);
    }

    @Override
    public int createBreedBreedOut(BBreedOut data) {
        BBreed breed = breedMapper.selectById(data.getBId());
        if(breed!=null){
            breed.setStatus(1);
            breedMapper.updateById(breed);
            data.setOutTime(LocalDateTime.now());
          return  baseMapper.insert(data);
        }
        return 0;
    }
}
