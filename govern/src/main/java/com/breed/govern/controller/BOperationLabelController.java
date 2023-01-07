package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.OperationLabelListVo;
import com.breed.govern.dto.vo.SelectOperationLabelListVo;
import com.breed.govern.entity.BOperationLabel;
import com.breed.govern.service.IBOperationLabelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 普通操作标签表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
@RestController
@RequestMapping("/operation-label")
public class BOperationLabelController {
    @Autowired
    private IBOperationLabelService labelService;

    @ApiOperation("添加操作标签信息")
    @PostMapping(value = "/create")
    public CommonResult createOperationLabel(@RequestBody BOperationLabel OperationLabel) {

        int count = labelService.createOperationLabel(OperationLabel);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改操作标签信息")
    @PostMapping(value = "/update")
    public CommonResult updateOperationLabel(@RequestBody BOperationLabel OperationLabel) {

        int count = labelService.updateOperationLabel(OperationLabel);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取操作标签信息")
    @GetMapping(value = "/list")
    public CommonResult<List<OperationLabelListVo>> getOperationLabelList(@RequestParam(value = "bid", defaultValue = "0") long bid) {
        List<OperationLabelListVo> evaluateList = labelService.getOperationLabelList();
        return CommonResult.success(evaluateList);
    }

    @ApiOperation("删除操作标签信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteOperationLabel(@PathVariable Long id) {
        Integer count = labelService.deleteOperationLabel(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id获取发酵信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BOperationLabel> getOperationLabelById(@PathVariable Integer id) {
        return CommonResult.success(labelService.getOperationLabelById(id));
    }

    @ApiOperation("选择标签数据")
    @GetMapping(value = "/select/list")
    public CommonResult<List<SelectOperationLabelListVo>> selectOperationLabelListVo() {
        return CommonResult.success(labelService.selectOperationLabelListVo());
    }

}
