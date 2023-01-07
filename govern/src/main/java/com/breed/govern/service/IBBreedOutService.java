package com.breed.govern.service;

import com.breed.govern.entity.BBreedOut;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 产出记录 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-13
 */
public interface IBBreedOutService extends IService<BBreedOut> {
    List<BBreedOut> getBreedOutInfoList(Integer bid);

    int createBreedBreedOut( BBreedOut data);
}
