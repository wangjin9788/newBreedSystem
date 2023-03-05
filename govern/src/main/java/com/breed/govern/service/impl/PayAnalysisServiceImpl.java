package com.breed.govern.service.impl;

import com.breed.govern.dto.vo.PayCategoryPicAnalysisVo;
import com.breed.govern.dto.vo.PayDetailAnalysisVo;
import com.breed.govern.dto.vo.PayRevenuePieAnalysisVo;
import com.breed.govern.mapper.PayAnalysisMapper;
import com.breed.govern.service.IPayAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayAnalysisServiceImpl  implements IPayAnalysisService {

    @Resource
    private PayAnalysisMapper analysisMapper;


    /**
     * 柱状图---年月日详情统计
     * @return
     */
    @Override
    public List<PayDetailAnalysisVo> getPayAndRevenueAnalysis(String time) {
       return analysisMapper.getPayAndRevenueAnalysis(time);
    }

    /**
     * 饼状图---年收入支出比例
     * @param time
     * @return
     */
    @Override
    public List<PayRevenuePieAnalysisVo> getPayPicAnalysis(String time) {
        return analysisMapper.getPayPicAnalysis(time);
    }

    /**
     * 饼状图---支出比例统计
     * @param time
     * @return
     */
    @Override
    public List<PayCategoryPicAnalysisVo> getPayCategoryAnalysis(String time) {
        return analysisMapper.getPayCategoryAnalysis(time);
    }

    @Override
    public List<Integer> getYearData() {
        return analysisMapper.getYearData();
    }

    @Override
    public List<Integer> getMonth() {
        return analysisMapper.getMonth();
    }
}
