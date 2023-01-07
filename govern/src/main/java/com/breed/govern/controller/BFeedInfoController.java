package com.breed.govern.controller;


import com.breed.govern.common.api.CommonResult;
import com.breed.govern.dto.vo.FeedInfoListVo;
import com.breed.govern.dto.vo.SelectFeedListVo;
import com.breed.govern.dto.vo.SelectFermentListVo;
import com.breed.govern.entity.BFeedInfo;
import com.breed.govern.service.IBFeedInfoService;
import io.swagger.annotations.Api;
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
 * @since 2022-12-04
 */
@Api("饲料信息控制器")
@RestController
@RequestMapping("/feed-info")
public class BFeedInfoController {

    @Autowired
    private IBFeedInfoService infoService;
    @ApiOperation("添加发酵信息")
    @PostMapping(value = "/create")
    public CommonResult createFeedInfo(@RequestBody BFeedInfo feedInfo) {

        int count = infoService.createFeedInfo(feedInfo);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改发酵信息")
    @PostMapping(value = "/update")
    public CommonResult updateFeedInfo(@RequestBody BFeedInfo feedInfo) {

        int count = infoService.updateFeedInfo(feedInfo);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除发酵信息")
    @PostMapping("/delete/{id}")
    public CommonResult deleteFeedInfo(@PathVariable Long id) {
        Integer count = infoService.deleteFeedInfo(id);
        if (count > 0) {

            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取发酵列表")
    @GetMapping(value = "/list")
    public CommonResult<List<FeedInfoListVo>> getFeedInfoList() {
        return CommonResult.success(infoService.getFeedInfoList());
    }

    @ApiOperation("根据id获取发酵信息")
    @GetMapping(value = "/info/{id}")
    public CommonResult<BFeedInfo> getFeedInfoById(@PathVariable Integer id) {
        return CommonResult.success(infoService.getFeedInfoById(id));
    }

    @ApiOperation("选取饲料列表")
    @GetMapping(value = "/select/list")
    public CommonResult<List<SelectFeedListVo>> selectFeedList() {
        return CommonResult.success(infoService.selectFeedList());
    }
}
