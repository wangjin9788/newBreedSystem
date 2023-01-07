package com.breed.govern.service.impl;

import com.breed.govern.entity.BTipsInfo;
import com.breed.govern.mapper.BTipsInfoMapper;
import com.breed.govern.service.IBTipsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 提示表 服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-24
 */
@Service
public class BTipsInfoServiceImpl extends ServiceImpl<BTipsInfoMapper, BTipsInfo> implements IBTipsInfoService {

    @Override
    public List<BTipsInfo> getTipsInfo() {
        return baseMapper.selectList(null);
    }
}
