package com.breed.govern.service;

import com.breed.govern.common.api.CommonResult;
import com.breed.govern.entity.BFermentTesting;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 发酵结束表
 * 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-11
 */
public interface IBFermentTestingService extends IService<BFermentTesting> {
    @ApiOperation("添加发酵信息")
    @PostMapping(value = "/create")
    int createFermentTesting(@RequestBody BFermentTesting data);

    int updateFermentTesting(BFermentTesting data);


    int deleteFermentTesting(Long id);

    List<BFermentTesting> getFermentTestingList(Long ffid);

    BFermentTesting getFermentTestingById(Integer id);
}
