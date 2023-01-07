package com.breed.govern.mapper;

import com.breed.govern.dto.vo.FeedInfoListVo;
import com.breed.govern.dto.vo.SelectFeedListVo;
import com.breed.govern.entity.BFeedInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
public interface BFeedInfoMapper extends BaseMapper<BFeedInfo> {

   List<FeedInfoListVo> getFeedInfoList();

   List<SelectFeedListVo> selectFeedListVo();
}
