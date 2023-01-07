package com.breed.govern.service;

import com.breed.govern.entity.BExcSummary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 问题解决汇总表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface IBExcSummaryService extends IService<BExcSummary> {

    long getSummaryByLabel(String data);

    List<BExcSummary> getSummaryList();

}
