package com.breed.govern.service;

import com.breed.govern.dto.vo.ExcInfoList;
import com.breed.govern.entity.BExcInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 异常信息表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface IBExcInfoService extends IService<BExcInfo> {
    List<ExcInfoList> getExcInfoList();

    int updateStatusAndInsertSummary( Integer eId);

    List<Long> getEIdByBId(List<Long > idList);

    List<BExcInfo>getDayExcInfo();
}
