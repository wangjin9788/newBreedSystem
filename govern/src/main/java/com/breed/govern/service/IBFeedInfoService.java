package com.breed.govern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.dto.vo.FeedInfoListVo;
import com.breed.govern.dto.vo.SelectFeedListVo;
import com.breed.govern.entity.BFeedInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
public interface IBFeedInfoService extends IService<BFeedInfo> {
    int createFeedInfo(BFeedInfo feedInfo);

    int updateFeedInfo(BFeedInfo feedInfo);

    Integer deleteFeedInfo(long id);

    List<FeedInfoListVo> getFeedInfoList();

    BFeedInfo getFeedInfoById( Integer id);

    List<SelectFeedListVo> selectFeedList();
}
