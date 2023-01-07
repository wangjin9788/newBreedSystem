package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.BreedListVo;
import com.breed.govern.entity.BBreed;
import com.breed.govern.service.IBBreedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 *
 * @author 王进
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/breed")
@Api(tags = "BBreedController", description = "养殖信息管理")
public class BBreedController {

    @Autowired
    private IBBreedService breedService;

    @ApiOperation("添加养殖信息")
    @PostMapping(value = "/create")
    public CommonResult createBreed(@RequestBody BBreed breed) {

        int count = breedService.createBreed(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改养殖信息")
    @PostMapping(value = "/update")
    public CommonResult updateBreed(@RequestBody BBreed breed) {

        int count = breedService.updateBreed(breed);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取养殖信息")
    @GetMapping(value = "/list")
    public CommonResult<List<BreedListVo>> getBreedList(@RequestParam(value = "status", defaultValue = "0") Integer status,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "type", defaultValue = "0") Integer type) {
        List<BreedListVo> evaluateList = breedService.getBreedList(status, pageSize, pageNum, type);
        return CommonResult.success(evaluateList);
    }

    @ApiOperation("删除养殖信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreed(@PathVariable Long id) {
        Integer count = breedService.deleteBreed(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id获取发酵信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BBreed> getBreedById(@PathVariable Integer id) {
        return CommonResult.success(breedService.getBreedById(id));
    }
    @ApiOperation("获取所有Id")
    @GetMapping(value = "/all")
    public CommonResult<List<Long>> getBreedAllId() {
        return CommonResult.success(breedService.getBreedAllId());
    }
}
