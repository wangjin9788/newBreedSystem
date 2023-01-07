package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.ExcInfoList;
import com.breed.govern.service.IBExcInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 异常信息表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@RestController
@RequestMapping("/exc-info")
@Api("治疗信息")
public class BExcInfoController {

    @Autowired
    private IBExcInfoService infoService;

    @ApiOperation("获取异常信息列表")
    @GetMapping("/list")
    public CommonResult<List<ExcInfoList>> getExcInfoList(){
        return  CommonResult.success(infoService.getExcInfoList());
    }

    @PostMapping("/update/status/{eId}")
    public CommonResult updateStatusAndInsertSummary(@PathVariable Integer eId){
        return  CommonResult.success(infoService.updateStatusAndInsertSummary(eId));
    }
}
