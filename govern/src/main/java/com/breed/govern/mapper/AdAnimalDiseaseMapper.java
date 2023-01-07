package com.breed.govern.mapper;

import com.breed.govern.dto.vo.AdNatureListVo;
import com.breed.govern.entity.AdAnimalDisease;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 动物病理信息表 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-04
 */
public interface AdAnimalDiseaseMapper extends BaseMapper<AdAnimalDisease> {
    List<AdNatureListVo> getAdAnimalDiseaseList(@Param(value = "searchName")String searchName);

    long  getDiseaseExcInfo(@Param(value = "data")String data);
}
