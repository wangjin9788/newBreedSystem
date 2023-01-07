package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.SelectExcLabelList;
import com.breed.govern.entity.BExcLabel;
import com.breed.govern.service.IBExcLabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 检测病害标签表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@RestController
@RequestMapping("/exc-label")
@Api("异常标签")
public class BExcLabelController {
    @Autowired
    private IBExcLabelService labelService;

    @ApiOperation("获取模型列表")
    @GetMapping("/list")
    public CommonResult<List<BExcLabel>> getExcLabelList(){
        return  CommonResult.success(labelService.getExcLabelList());
    }

    @ApiOperation("新建模型")
    @PostMapping(value = "/create")
    public CommonResult createBreed(@RequestBody BExcLabel label) {

        int count = labelService.createExcLabel(label);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改模型")
    @PostMapping(value = "/update")
    public CommonResult updateFeedInfo(@RequestBody BExcLabel label) {

        int count = labelService.updateExcLabel(label);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除模型")
    @PostMapping("/delete/{id}")
    public CommonResult deleteFeedInfo(@PathVariable Long id) {
        Integer count = labelService.deleteExcLabel(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据id获取模型数据")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BExcLabel> getFeedFermentById(@PathVariable Integer id) {
        return CommonResult.success(labelService.getExcLabelById(id));
    }
    @ApiOperation("选择模型数据")
    @GetMapping(value = "/select/list")
    public CommonResult<List<SelectExcLabelList>> SelectExcLabelList() {
        return CommonResult.success(labelService.SelectExcLabelList());
    }
}
