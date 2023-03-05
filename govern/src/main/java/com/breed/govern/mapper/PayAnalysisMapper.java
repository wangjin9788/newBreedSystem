package com.breed.govern.mapper;

import com.breed.govern.dto.vo.PayCategoryPicAnalysisVo;
import com.breed.govern.dto.vo.PayDetailAnalysisVo;
import com.breed.govern.dto.vo.PayRevenuePieAnalysisVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayAnalysisMapper {

    List<PayDetailAnalysisVo> getPayAndRevenueAnalysis(@Param("time") String time);

    List<PayRevenuePieAnalysisVo> getPayPicAnalysis(@Param("time") String time);

    List<PayCategoryPicAnalysisVo> getPayCategoryAnalysis(@Param("time") String time);

    List<Integer> getYearData();

    List<Integer> getMonth();
}
