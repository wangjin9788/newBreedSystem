package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.SelectAdNatureListVo;
import com.breed.govern.entity.AdNature;
import com.breed.govern.service.IAdNatureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 病害性质 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
@RestController
@RequestMapping("/nature")
@Api("病理性质表")
public class AdNatureController {
    @Autowired
    private IAdNatureService natureService;
    @ApiOperation("获取病理性质列表")
    @GetMapping("/list")
    public CommonResult<List<AdNature>> getAdNatureList(){
        return  CommonResult.success(natureService.getAdNatureList());
    }

    @ApiOperation("新建病理性质")
    @PostMapping(value = "/create")
    public CommonResult createAdNature(@RequestBody AdNature data) {

        int count = natureService.createAdNature(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改病理性质")
    @PostMapping(value = "/update")
    public CommonResult updateAdNature(@RequestBody AdNature data) {

        int count = natureService.updateAdNature(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除病理性质")
    @PostMapping("/delete/{id}")
    public CommonResult deleteAdNature(@PathVariable Long id) {
        Integer count = natureService.deleteAdNature(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据id获取模型数据")
    @GetMapping(value = "/info/{id}")
    public CommonResult<AdNature> getFeedFermentById(@PathVariable Integer id) {
        return CommonResult.success(natureService.getAdNatureById(id));
    }
    @ApiOperation("选择病理性质数据")
    @GetMapping(value = "/select/list")
    public CommonResult<List<SelectAdNatureListVo>> selectAdNatureAdNatureListVo() {
        return CommonResult.success(natureService.selectAdNatureListVo());
    }
}
