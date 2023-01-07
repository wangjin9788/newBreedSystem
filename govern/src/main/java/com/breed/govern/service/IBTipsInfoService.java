package com.breed.govern.service;

import com.breed.govern.entity.BTipsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 提示表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-24
 */
public interface IBTipsInfoService extends IService<BTipsInfo> {

    List<BTipsInfo>getTipsInfo();

}
