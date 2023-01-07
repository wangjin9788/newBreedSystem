package com.breed.govern.controller;

import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.PayCategoryPicAnalysisVo;
import com.breed.govern.dto.vo.PayDetailAnalysisVo;
import com.breed.govern.dto.vo.PayRevenuePieAnalysisVo;
import com.breed.govern.service.IPayAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "PayAnalysisController", description = "支出统计")
@RequestMapping("/pay-analysis")
public class PayAnalysisController {
    @Autowired
    private IPayAnalysisService payAnalysisService;


    @ApiOperation("支出营收统计-柱状图")
    @GetMapping(value = "/pay_revenue_analysis")
    public CommonResult<List<PayDetailAnalysisVo>> getPayAndRevenueAnalysis() {
        List<PayDetailAnalysisVo> payAndRevenueAnalysis = payAnalysisService.getPayAndRevenueAnalysis();
        return CommonResult.success(payAndRevenueAnalysis);
    }

    @ApiOperation("支出营百分比-饼状图")
    @GetMapping(value = "/year_pic_analysis/{yearPic}")
    public CommonResult<List<PayRevenuePieAnalysisVo>> getPayPicAnalysis(@PathVariable("yearPic") String yearPic) {
        List<PayRevenuePieAnalysisVo> yearPicAnalysis = payAnalysisService.getPayPicAnalysis(yearPic);
        return CommonResult.success(yearPicAnalysis);
    }
    @ApiOperation("支出品类百分比-饼状图")
    @GetMapping(value = "/pay_category_analysis/{yearPayTime}")
    public CommonResult<List<PayCategoryPicAnalysisVo>> getPayCategoryAnalysis(@PathVariable("yearPayTime") String yearPayTime) {
        List<PayCategoryPicAnalysisVo> yearPicAnalysis = payAnalysisService.getPayCategoryAnalysis(yearPayTime);
        return CommonResult.success(yearPicAnalysis);
    }
    @ApiOperation("获取年份")
    @GetMapping(value = "/year")
    public CommonResult<List<Integer>> getYearData() {
        List<Integer> yearPicAnalysis = payAnalysisService.getYearData();
        return CommonResult.success(yearPicAnalysis);
    }
    @ApiOperation("获取月份")
    @GetMapping(value = "/month")
    public CommonResult<List<Integer>> getMonthData() {
        List<Integer> yearPicAnalysis = payAnalysisService.getYearData();
        return CommonResult.success(yearPicAnalysis);
    }


}
