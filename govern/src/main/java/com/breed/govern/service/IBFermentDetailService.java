package com.breed.govern.service;

import com.breed.govern.entity.BFermentDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2023-03-25
 */
public interface IBFermentDetailService extends IService<BFermentDetail> {
    int createFermentDetail(BFermentDetail data);

    int updateFermentDetail(BFermentDetail data);

    int deleteFermentDetail(Long id);

    List<BFermentDetail> getFermentDetailList( Long ffId,
                                               Integer pageNum,
                                               Integer pageSize);

    BFermentDetail getFermentDetailById(Long id);
}
