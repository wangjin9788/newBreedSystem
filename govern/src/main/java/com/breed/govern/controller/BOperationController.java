package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.OperationListVo;
import com.breed.govern.dto.vo.SelectBreedModelListVo;
import com.breed.govern.dto.vo.SelectOperationLabelListVo;
import com.breed.govern.dto.vo.SelectOperationList;
import com.breed.govern.entity.BOperation;
import com.breed.govern.service.IBOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 普通操作表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-08
 */
@Api("日常操作信息")
@RestController
@RequestMapping("/operation")
public class BOperationController {
    @Autowired
    private IBOperationService operationService;

    @ApiOperation("添加操作标签信息")
    @PostMapping(value = "/create")
    public CommonResult createOperation(@RequestBody BOperation operation) {

        int count = operationService.createOperation(operation);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改操作标签信息")
    @PostMapping(value = "/update")
    public CommonResult updateOperation(@RequestBody BOperation operation) {

        int count = operationService.updateOperation(operation);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取操作标签信息")
    @GetMapping(value = "/list")
    public CommonResult<List<OperationListVo>> getOperationList(@RequestParam(value = "bid") long bid,
                                                                @RequestParam(value = "type") int type) {
        List<OperationListVo> evaluateList = operationService.getOperationList(bid,type);
        return CommonResult.success(evaluateList);
    }

    @ApiOperation("删除操作信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteOperation(@PathVariable Long id) {
        Integer count = operationService.deleteOperation(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id获取操作标签信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BOperation> getOperationById(@PathVariable Integer id) {
        return CommonResult.success(operationService.getOperationById(id));
    }
    @ApiOperation("选择操作数据")
    @GetMapping(value = "/select/list")
    public CommonResult<List<SelectOperationList>> selectOperationList() {
        return CommonResult.success(operationService.selectOperationList());
    }

}
