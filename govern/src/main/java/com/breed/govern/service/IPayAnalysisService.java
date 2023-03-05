package com.breed.govern.service;

import com.breed.govern.dto.vo.PayCategoryPicAnalysisVo;
import com.breed.govern.dto.vo.PayDetailAnalysisVo;
import com.breed.govern.dto.vo.PayRevenuePieAnalysisVo;

import java.util.List;

public interface IPayAnalysisService {

    List<PayDetailAnalysisVo> getPayAndRevenueAnalysis(String time);

    List<PayRevenuePieAnalysisVo> getPayPicAnalysis(String time);

    List<PayCategoryPicAnalysisVo> getPayCategoryAnalysis(String time);

    List<Integer> getYearData();

    List<Integer> getMonth();
}
