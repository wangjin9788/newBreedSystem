package com.breed.govern.service;

import com.breed.govern.dto.vo.BreedListVo;
import com.breed.govern.entity.BBreed;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
public interface IBBreedService extends IService<BBreed> {
    int createBreed(BBreed breed);

    int updateBreed(BBreed breed);

    List<BreedListVo> getBreedList(Integer status, Integer pageSize, Integer pageNum, Integer type);

    BBreed getBreedById(long id);


    Integer deleteBreed(long id);

    List<Long> getBreedAllId();


}
