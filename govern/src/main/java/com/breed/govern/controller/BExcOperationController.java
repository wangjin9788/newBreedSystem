package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.ExcOperationListVo;
import com.breed.govern.dto.vo.GetExcOperationInfo;
import com.breed.govern.entity.BExcOperation;
import com.breed.govern.service.IBExcOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 异常操作表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
@RestController
@RequestMapping("/exc-operation")
@Api("治疗操作")
public class BExcOperationController {
    @Autowired
    private IBExcOperationService excOperationService;

    @ApiOperation("添加操作标签信息")
    @PostMapping(value = "/create")
    public CommonResult createExcOperation(@RequestBody BExcOperation data) {

        int count = excOperationService.createExcOperation(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改操作标签信息")
    @PostMapping(value = "/update")
    public CommonResult updateExcOperation(@RequestBody BExcOperation data) {

        int count = excOperationService.updateExcOperation(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取操作标签信息")
    @GetMapping(value = "/list")
    public CommonResult<List<ExcOperationListVo>> getExcOperationList(@RequestParam(value = "eid") long eid) {
        List<ExcOperationListVo> evaluateList = excOperationService.getExcOperationList(eid);
        return CommonResult.success(evaluateList);
    }

    @ApiOperation("删除操作信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteExcOperation(@PathVariable Long id) {
        Integer count = excOperationService.deleteExcOperation(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id获取操作标签信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BExcOperation> getExcOperationById(@PathVariable Integer id) {
        return CommonResult.success(excOperationService.getExcOperationById(id));
    }
    @ApiOperation("根据Eid获取操作标签信息")
    @GetMapping(value = "/summary/operation/{id}")
    public CommonResult<List<GetExcOperationInfo>> getExcOperationByEid(@PathVariable Integer id) {
        return CommonResult.success(excOperationService.getExcOperationByEid(id));
    }


}
