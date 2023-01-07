package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.BreedListVo;
import com.breed.govern.entity.BBreed;
import com.breed.govern.entity.BBreedOut;
import com.breed.govern.service.IBBreedOutService;
import com.breed.govern.service.IBBreedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 产出记录 前端控制器
 * </p>
 *
 * @author 王进
 * @since 2022-12-13
 */
@RestController
@RequestMapping("/breed-out")
@Api("养殖结束记录")
public class BBreedOutController {
    @Autowired
    private IBBreedOutService outService;

    @ApiOperation("添加养殖结束信息")
    @PostMapping(value = "/create")
    public CommonResult createBreedBreedOut(@RequestBody BBreedOut data) {

        int count = outService.createBreedBreedOut(data);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取养殖信息结束信息")
    @GetMapping(value = "/list")
    public CommonResult<List<BBreedOut>> getBreedOutInfoList(
            @RequestParam(value = "bid", defaultValue = "0") Integer bid) {
        List<BBreedOut> evaluateList = outService.getBreedOutInfoList(bid);
        return CommonResult.success(evaluateList);
    }

}
