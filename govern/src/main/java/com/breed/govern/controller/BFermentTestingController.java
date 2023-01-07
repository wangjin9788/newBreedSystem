package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.entity.BFermentTesting;
import com.breed.govern.service.IBFermentTestingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 发酵结束表
 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-11
 */
@RestController
@RequestMapping("/ferment-testing")
@Api("发酵结束信息检测")
public class BFermentTestingController {
    @Autowired
    private IBFermentTestingService fermentTestingService;

    @ApiOperation("添加发酵信息")
    @PostMapping(value = "/create")
    public CommonResult createFermentTesting(@RequestBody BFermentTesting data) {

        int count = fermentTestingService.createFermentTesting(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改发酵信息")
    @PostMapping(value = "/update")
    public CommonResult updateFermentTesting(@RequestBody BFermentTesting data) {

        int count = fermentTestingService.updateFermentTesting(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除发酵信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteFermentTesting(@PathVariable Long id) {
        Integer count = fermentTestingService.deleteFermentTesting(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取发酵列表")
    @GetMapping(value = "/list")
    public CommonResult<List<BFermentTesting>> getFermentTestingList(@RequestParam(value = "ffId") Long ffId) {
        return CommonResult.success(fermentTestingService.getFermentTestingList( ffId));
    }

    @ApiOperation("根据id获取发酵信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BFermentTesting> getFermentTestingById(@PathVariable Integer id) {
        return CommonResult.success(fermentTestingService.getFermentTestingById(id));
    }
}
