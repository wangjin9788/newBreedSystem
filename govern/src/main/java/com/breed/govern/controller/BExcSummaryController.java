package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.entity.BExcSummary;
import com.breed.govern.service.IBExcSummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 问题解决汇总表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@RestController
@RequestMapping("/exc-summary")
@Api("疾病总结")
public class BExcSummaryController {

    @Autowired
    private IBExcSummaryService summaryService;

    @ApiOperation("获取疾病总结列表")
    @GetMapping(value = "/list")
    public CommonResult<List<BExcSummary>> getSummaryList(){
        List<BExcSummary> summaryList = summaryService.getSummaryList();
        return CommonResult.success(summaryList);
    }
}
