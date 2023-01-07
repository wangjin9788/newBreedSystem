package com.breed.govern.service;

import com.breed.govern.dto.param.FermentEndTestingParam;
import com.breed.govern.dto.vo.FermentListVo;
import com.breed.govern.dto.vo.SelectFermentListVo;
import com.breed.govern.entity.BFeedFerment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.entity.BFermentTesting;

import java.util.List;

/**
 * <p>
 * 发酵表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
public interface IBFeedFermentService extends IService<BFeedFerment> {
    int createFeedFerment(BFeedFerment ferment);

    int updateFeedFerment(BFeedFerment ferment);

    Integer deleteFeedFerment(long id);

    Integer updateStatus(BFermentTesting data);

    List<FermentListVo> getFermentList( String selectDay);

    BFeedFerment getFeedFermentById( Integer id);

    List<SelectFermentListVo> getSelectFermentList();
}
