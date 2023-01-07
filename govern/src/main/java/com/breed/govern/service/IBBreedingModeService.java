package com.breed.govern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.dto.vo.BreedModelListVo;
import com.breed.govern.dto.vo.SelectBreedModelListVo;
import com.breed.govern.entity.BBreedingMode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-03
 */
public interface IBBreedingModeService extends IService<BBreedingMode> {
    int createBreedingMode(BBreedingMode model);

    int updateBreedingMode(BBreedingMode model);

    Integer deleteBreedingMode(long id);


    BBreedingMode getBreedingModeById( Integer id);

    List<BreedModelListVo> getModelList();

    List<SelectBreedModelListVo> selectBreedModelListVoList();
}
