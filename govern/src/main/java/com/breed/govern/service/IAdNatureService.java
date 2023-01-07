package com.breed.govern.service;

import com.breed.govern.dto.vo.SelectAdNatureListVo;
import com.breed.govern.entity.AdNature;
import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.entity.BBreedingMode;

import java.util.List;

/**
 * <p>
 * 病害性质 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
public interface IAdNatureService extends IService<AdNature> {
    int createAdNature(AdNature nature);

    int updateAdNature(AdNature nature);

    Integer deleteAdNature(long id);


    AdNature getAdNatureById( Integer id);

    List<AdNature> getAdNatureList();

    List<SelectAdNatureListVo> selectAdNatureListVo();
}
