package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.RateItemVo;
import com.breed.govern.entity.BNutritionalRate;
import com.breed.govern.service.IBNutritionalRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 营养比例表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-17
 */
@RestController
@RequestMapping("/nutritional-rate")
@Api("比例信息")
public class BNutritionalRateController {

    @Autowired
    private IBNutritionalRateService rateService;

    @GetMapping("/list")
    @ApiOperation("查看列表")
    public CommonResult<List<RateItemVo>> getRateList(){
        return CommonResult.success(rateService.getRateList());
    }
    @PostMapping("/create")
    @ApiOperation("新增比例")
    public CommonResult createRate(@RequestBody BNutritionalRate rate){
        return CommonResult.success(rateService.createRate(rate));
    }
}
