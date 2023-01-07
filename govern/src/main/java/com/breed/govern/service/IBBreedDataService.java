package com.breed.govern.service;

import com.breed.govern.dto.vo.BreedDataList;
import com.breed.govern.dto.vo.CascaderBreedDataLabelList;
import com.breed.govern.entity.BBreedData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.breed.govern.entity.BBreedDataLabel;

import java.util.List;

/**
 * <p>
 * 养殖资料 服务类
 * </p>
 *
 * @author 王进
 * @since 2022-12-25
 */
public interface IBBreedDataService extends IService<BBreedData> {
    List<BreedDataList> getBreedDataList(Integer menuNumber, String searchNam, Integer dlId);

    Integer createBreedData(BBreedData data);

    Integer updateBreedData(BBreedData data);

    Integer deleteBreedData(Long id);

    BBreedData getBreedDataById(Integer id);

    List<BBreedDataLabel> selectBreedDataLabelInfo(Integer dlId);
    List<CascaderBreedDataLabelList> cascaderBreedDataLabelInfo();

}
