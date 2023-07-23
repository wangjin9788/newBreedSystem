package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.BreedListVo;
import com.breed.govern.dto.vo.BreedModelListVo;
import com.breed.govern.dto.vo.SelectBreedModelListVo;
import com.breed.govern.dto.vo.SelectFeedListVo;
import com.breed.govern.entity.BBreedingMode;
import com.breed.govern.entity.BFeedFerment;
import com.breed.govern.entity.BFeedInfo;
import com.breed.govern.service.IBBreedingModeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/breed-model")
public class BBreedingModeController {

    @Autowired
    private IBBreedingModeService modeService;

    @ApiOperation("获取模型列表")
    @GetMapping("/list")
    public CommonResult<List<BreedModelListVo>> getModelList(){
      return  CommonResult.success(modeService.getModelList());
    }

    @ApiOperation("新建模型")
    @PostMapping(value = "/create")
    public CommonResult createBreed(@RequestBody BBreedingMode feedInfo) {

        int count = modeService.createBreedingMode(feedInfo);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("修改模型")
    @PostMapping(value = "/update")
    public CommonResult updateFeedInfo(@RequestBody BBreedingMode feedInfo) {

        int count = modeService.updateBreedingMode(feedInfo);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("删除模型")
    @PostMapping("/delete/{id}")
    public CommonResult deleteFeedInfo(@PathVariable Long id) {
        Integer count = modeService.deleteBreedingMode(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据id获取模型数据")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BBreedingMode> getFeedFermentById(@PathVariable Integer id) {
        return CommonResult.success(modeService.getBreedingModeById(id));
    }
    @ApiOperation("选择模型数据")
    @GetMapping(value = "/select/list")
    public CommonResult<List<SelectBreedModelListVo>> selectBreedModelListVo() {
        return CommonResult.success(modeService.selectBreedModelListVoList());
    }
}
