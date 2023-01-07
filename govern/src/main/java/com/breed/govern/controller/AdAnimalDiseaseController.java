package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.AdNatureListVo;
import com.breed.govern.entity.AdAnimalDisease;
import com.breed.govern.service.IAdAnimalDiseaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 动物病理信息表 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
@RestController
@RequestMapping("/animal-disease")
@Api("病理表")
public class AdAnimalDiseaseController {

    @Autowired
    private IAdAnimalDiseaseService diseaseService;

    @ApiOperation("获取模型列表")
    @GetMapping("/list")
    public CommonResult<List<AdNatureListVo>> getModelList(@RequestParam(value = "searchName") String searchName){
        return  CommonResult.success(diseaseService.getAdAnimalDiseaseList(searchName));
    }

    @ApiOperation("新建病理信息")
    @PostMapping(value = "/create")
    public CommonResult createAdAnimalDisease(@RequestBody AdAnimalDisease data) {

        int count = diseaseService.createAdAnimalDisease(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改病理信息")
    @PostMapping(value = "/update")
    public CommonResult updateFeedInfo(@RequestBody AdAnimalDisease data) {

        int count = diseaseService.updateAdAnimalDisease(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除病理信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteFeedInfo(@PathVariable Long id) {
        Integer count = diseaseService.deleteAdAnimalDisease(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据id获取模型数据")
    @GetMapping(value = "/info/{id}")
    public CommonResult<AdAnimalDisease> getAdAnimalDiseaseById(@PathVariable Integer id) {
        return CommonResult.success(diseaseService.getAdAnimalDiseaseById(id));
    }

}
