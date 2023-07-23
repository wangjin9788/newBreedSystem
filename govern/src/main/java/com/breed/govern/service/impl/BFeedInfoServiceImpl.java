package com.breed.govern.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breed.govern.dto.vo.FeedInfoListVo;
import com.breed.govern.dto.vo.SelectFeedListVo;
import com.breed.govern.entity.BFeedInfo;
import com.breed.govern.mapper.BFeedInfoMapper;
import com.breed.govern.service.IBFeedInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
@Service
public class BFeedInfoServiceImpl extends ServiceImpl<BFeedInfoMapper, BFeedInfo> implements IBFeedInfoService {

    @Override
    public int createFeedInfo(BFeedInfo feedInfo) {
        return baseMapper.insert(feedInfo);
    }

    @Override
    public int updateFeedInfo(BFeedInfo feedInfo) {
        return baseMapper.updateById(feedInfo);
    }

    @Override
    public Integer deleteFeedInfo(long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<FeedInfoListVo> getFeedInfoList() {
        return baseMapper.getFeedInfoList();
    }

    @Override
    public BFeedInfo getFeedInfoById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<SelectFeedListVo> selectFeedList() {
        List<SelectFeedListVo> selectFeedListVos = baseMapper.selectFeedListVo();
        return selectFeedListVos;
    }
}
