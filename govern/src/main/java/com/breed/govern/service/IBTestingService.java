package com.breed.govern.service;

import com.breed.govern.dto.vo.TestingListVo;
import com.breed.govern.entity.BTesting;
import com.breed.govern.entity.BTesting;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 检测表 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-10
 */
public interface IBTestingService extends IService<BTesting> {
    int createTesting(BTesting data);

    int updateTesting(BTesting data);

    List<TestingListVo> getTestingList(long bid);

    BTesting getTestingById(long id);


    Integer deleteTesting(long id);

    List<BTesting>getDayTestingList();
}
