package com.breed.govern.mapper;

import com.breed.govern.dto.vo.BreedDataInfo;
import com.breed.govern.dto.vo.BreedDataList;
import com.breed.govern.entity.BBreedData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 养殖资料 Mapper 接口
 * </p>
 *
 * @author 王进
 * @since 2022-12-25
 */
public interface BBreedDataMapper extends BaseMapper<BBreedData> {

    List<BreedDataList> getBreedDataList(@Param(value = "menuNumber") Integer menuNumber,
                                         @Param(value = "searchName") String searchName,
                                         @Param(value = "dlId") Integer dlId
                                );

    BreedDataInfo getBreedDataById(@Param(value = "id")Integer id);
}
