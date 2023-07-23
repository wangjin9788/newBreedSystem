package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.entity.BFermentDetail;
import com.breed.govern.service.IBFermentDetailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王进
 * @since 2023-03-25
 */
@RestController
@RequestMapping("/ferment-detail")
public class BFermentDetailController {
    @Autowired
    private IBFermentDetailService fermentDetailService;

    @ApiOperation("添加发酵信息")
    @PostMapping(value = "/create")
    public CommonResult createFermentDetail(@RequestBody BFermentDetail data) {
        LocalDateTime localDateTime = data.getCreateTime().plusHours(8);
        data.setCreateTime(localDateTime);
        int count = fermentDetailService.createFermentDetail(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改发酵信息")
    @PostMapping(value = "/update")
    public CommonResult updateFermentDetail(@RequestBody BFermentDetail data) {
        LocalDateTime localDateTime = data.getCreateTime().plusHours(8);
        data.setCreateTime(localDateTime);
        int count = fermentDetailService.updateFermentDetail(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除发酵信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteFermentDetail(@PathVariable Long id) {
        Integer count = fermentDetailService.deleteFermentDetail(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取发酵信息列表")
    @GetMapping(value = "/list")
    public CommonResult<List<BFermentDetail>> getFermentDetailList(@RequestParam(value = "ffId")   Long ffId,
                                                                   @RequestParam(value = "pageNum")  Integer pageNum,
                                                                   @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return CommonResult.success(fermentDetailService.getFermentDetailList( ffId,pageNum,pageSize));
    }

    @ApiOperation("根据id获取发酵信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BFermentDetail> getFermentDetailById(@PathVariable Long id) {
        return CommonResult.success(fermentDetailService.getFermentDetailById(id));
    }
}

