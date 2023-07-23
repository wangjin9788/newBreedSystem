package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.param.FermentEndTestingParam;
import com.breed.govern.dto.vo.FermentListVo;
import com.breed.govern.dto.vo.SelectFermentListVo;
import com.breed.govern.entity.BFeedFerment;
import com.breed.govern.entity.BFermentTesting;
import com.breed.govern.service.IBFeedFermentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 发酵表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
@Api(value = "饲料发酵")
@RestController
@RequestMapping("/feed-ferment")
public class BFeedFermentController {
    @Autowired
    private IBFeedFermentService fermentService;

    @ApiOperation("添加发酵信息")
    @PostMapping(value = "/create")
    public CommonResult createFerment(@RequestBody BFeedFerment ferment) {

        int count = fermentService.createFeedFerment(ferment);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改发酵信息")
    @PostMapping(value = "/update")
    public CommonResult updateFerment(@RequestBody BFeedFerment ferment) {

        int count = fermentService.updateFeedFerment(ferment);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除发酵信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteFerment(@PathVariable Long id) {
        Integer count = fermentService.deleteFeedFerment(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("获取发酵列表")
    @GetMapping(value = "/list")
    public CommonResult<List<FermentListVo>> getFermentList(@RequestParam(value = "selectDay",required = false) String selectDay,
                                                            @RequestParam(value = "fermentStatus",required = false) int fermentStatus) {
        return CommonResult.success(fermentService.getFermentList(fermentStatus));
    }

    @ApiOperation("根据id获取发酵信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BFeedFerment> getFeedFermentById(@PathVariable long id) {
        return CommonResult.success(fermentService.getFeedFermentById(id));
    }

    @ApiOperation("选取发酵列表")
    @GetMapping(value = "/select/list")
    public CommonResult<List<SelectFermentListVo>> getSelectFermentList() {
        return CommonResult.success(fermentService.getSelectFermentList());
    }

    @ApiOperation("修改状态")
    @PostMapping("/update/status")
    public CommonResult updateStatus(@RequestBody BFermentTesting data) {
        Integer count = fermentService.updateStatus(data);
        if(count>0){
            return CommonResult.success(count);
        }
      return  CommonResult.failed();
    }

}
