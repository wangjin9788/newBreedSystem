package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.BreedDataList;
import com.breed.govern.dto.vo.CascaderBreedDataLabelList;
import com.breed.govern.entity.AdNature;
import com.breed.govern.entity.BBreedData;
import com.breed.govern.entity.BBreedDataLabel;
import com.breed.govern.service.IBBreedDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 养殖资料 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-25
 */
@RestController
@RequestMapping("/breed-data")
@Api("养殖资料")
public class BBreedDataController {

    @Autowired
    IBBreedDataService dataService;

    @ApiOperation("获取资料列表")
    @GetMapping("/list")
    public CommonResult<List<BreedDataList>> getBreedDataList(@RequestParam(value = "menuNumber")Integer menuNumber,
                                                              @RequestParam(value = "dlId")Integer dlId,
                                                              @RequestParam(value = "searchName")String searchName){
        return  CommonResult.success(dataService.getBreedDataList(menuNumber,searchName,dlId));
    }

    @ApiOperation("新建资料")
    @PostMapping(value = "/create")
    public CommonResult createBreedData(@RequestBody BBreedData data) {
        int count = dataService.createBreedData(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改养殖资料")
    @PostMapping(value = "/update")
    public CommonResult updateBreedData(@RequestBody BBreedData data) {

        int count = dataService.updateBreedData(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除养殖资料")
    @PostMapping("/delete/{id}")
    public CommonResult deleteBreedData(@PathVariable Long id) {
        Integer count = dataService.deleteBreedData(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据id获取模型数据")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BBreedData> getBreedDataById(@PathVariable Integer id) {
        return CommonResult.success(dataService.getBreedDataById(id));
    }

    @ApiOperation("获取搜索标签")
    @GetMapping(value = "/select/label")
    public CommonResult<List<BBreedDataLabel>> selectBreedDataLabelInfo(@RequestParam(value = "menuNumber")Integer menuNumber) {
        return CommonResult.success(dataService.selectBreedDataLabelInfo(menuNumber));
    }
    @ApiOperation("获取新增标签")
    @GetMapping(value = "/cascader/label")
    public CommonResult<List<CascaderBreedDataLabelList>> cascaderBreedDataLabelInfo() {
        return CommonResult.success(dataService.cascaderBreedDataLabelInfo());
    }
}
