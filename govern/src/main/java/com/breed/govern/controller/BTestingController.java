package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.TestingListVo;
import com.breed.govern.entity.BTesting;
import com.breed.govern.service.IBTestingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 检测表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@Api("检测信息")
@RestController
@RequestMapping("/testing")
public class BTestingController {
    @Autowired
    private IBTestingService testingService;

    @ApiOperation("添加操作标签信息")
    @PostMapping(value = "/create")
    public CommonResult createTesting(@RequestBody BTesting testing) {

        int count = testingService.createTesting(testing);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改操作标签信息")
    @PostMapping(value = "/update")
    public CommonResult updateTesting(@RequestBody BTesting testing) {

        int count = testingService.updateTesting(testing);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取操作标签信息")
    @GetMapping(value = "/list")
    public CommonResult<List<TestingListVo>> getTestingList(@RequestParam(value = "bid") long bid) {
        List<TestingListVo> evaluateList = testingService.getTestingList(bid);
        return CommonResult.success(evaluateList);
    }

    @ApiOperation("删除操作信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteTesting(@PathVariable Long id) {
        Integer count = testingService.deleteTesting(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id获取操作标签信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BTesting> getTestingById(@PathVariable Integer id) {
        return CommonResult.success(testingService.getTestingById(id));
    }
}
